document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const role = document.getElementById('role').value;

    fetch('/api/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ username, password, role })
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Login failed. Please check your credentials.');
        }
        return response.json();
    })
    .then(data => {
        localStorage.setItem('token', data.token);
        // Redirect to respective dashboard based on role
        if (role === 'STUDENT') {
            window.location.href = 'student-dashboard.html';
        } else if (role === 'FACULTY_MEMBER') {
            window.location.href = 'faculty-dashboard.html';
        } else if (role === 'ADMINISTRATOR') {
            window.location.href = 'administrator-dashboard.html';
        }
    })
    .catch(error => {
        document.getElementById('errorMessage').innerText = error.message;
    });
});

// Fetch student profile and list
function loadStudentDashboard() {
    const token = localStorage.getItem('token');
    fetch('/api/student/profile', {
        headers: {
            'Authorization': 'Bearer ' + token
        }
    })
    .then(response => response.json())
    .then(data => {
        document.getElementById('studentProfile').innerHTML = `
            <p>Name: ${data.name}</p>
            <p>Email: ${data.email}</p>
            <p>Department: ${data.department}</p>
        `;
    });

    document.getElementById('searchBtn').addEventListener('click', function() {
        const query = document.getElementById('searchQuery').value;
        fetch('/api/student/search?query=' + query, {
            headers: {
                'Authorization': 'Bearer ' + token
            }
        })
        .then(response => response.json())
        .then(data => {
            const studentList = document.getElementById('studentList');
            studentList.innerHTML = '';

            data.forEach(student => {
                const li = document.createElement('li');
                li.textContent = `${student.name} - ${student.department}`;
                studentList.appendChild(li);
            });
        });
    });
}

// Call this function on student dashboard load
loadStudentDashboard();
