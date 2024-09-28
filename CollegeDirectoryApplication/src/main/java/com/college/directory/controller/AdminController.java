package com.college.directory.controller;

import com.college.directory.entity.StudentProfile;
import com.college.directory.entity.FacultyProfile;
import com.college.directory.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/add/student")
    public void addStudent(@RequestBody StudentProfile studentProfile) {
        adminService.addStudent(studentProfile);
    }

    @PostMapping("/add/faculty")
    public void addFaculty(@RequestBody FacultyProfile facultyProfile) {
        adminService.addFaculty(facultyProfile);
    }

    @DeleteMapping("/remove/student/{id}")
    public void removeStudent(@PathVariable Long id) {
        adminService.removeStudent(id);
    }

    @DeleteMapping("/remove/faculty/{id}")
    public void removeFaculty(@PathVariable Long id) {
        adminService.removeFaculty(id);
    }
}
