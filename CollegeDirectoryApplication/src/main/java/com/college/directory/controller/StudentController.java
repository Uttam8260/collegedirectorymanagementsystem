package com.college.directory.controller;

import com.college.directory.entity.StudentProfile;
import com.college.directory.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/profile/{id}")
    public StudentProfile getProfile(@PathVariable Long id) {
        return studentService.getStudentProfileById(id);
    }

    @GetMapping("/search")
    public List<StudentProfile> searchStudents(@RequestParam String name) {
        return studentService.searchStudentsByName(name);
    }
}
