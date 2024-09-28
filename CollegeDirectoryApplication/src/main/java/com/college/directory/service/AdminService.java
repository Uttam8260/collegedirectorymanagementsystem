package com.college.directory.service;

import com.college.directory.entity.StudentProfile;
import com.college.directory.entity.FacultyProfile;
import com.college.directory.repository.StudentProfileRepository;
import com.college.directory.repository.FacultyProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

	@Autowired
    private final StudentProfileRepository studentProfileRepository;
	@Autowired
	private final FacultyProfileRepository facultyProfileRepository;

    public AdminService(StudentProfileRepository studentProfileRepository, FacultyProfileRepository facultyProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
        this.facultyProfileRepository = facultyProfileRepository;
    }

    public void addStudent(StudentProfile studentProfile) {
        studentProfileRepository.save(studentProfile);
    }

    public void addFaculty(FacultyProfile facultyProfile) {
        facultyProfileRepository.save(facultyProfile);
    }

    public void removeStudent(Long id) {
        studentProfileRepository.deleteById(id);
    }

    public void removeFaculty(Long id) {
        facultyProfileRepository.deleteById(id);
    }
}
