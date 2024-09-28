package com.college.directory.controller;

import com.college.directory.entity.FacultyProfile;
import com.college.directory.service.FacultyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController {
	@Autowired
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("/profile/{id}")
    public FacultyProfile getProfile(@PathVariable Long id) {
        return facultyService.getFacultyProfileById(id);
    }

    @PutMapping("/profile/update")
    public void updateProfile(@RequestBody FacultyProfile facultyProfile) {
        facultyService.updateProfile(facultyProfile);
    }
}
