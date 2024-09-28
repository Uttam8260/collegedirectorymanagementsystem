package com.college.directory.service;

import com.college.directory.entity.FacultyProfile;
import com.college.directory.repository.FacultyProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyService {

	@Autowired
    private final FacultyProfileRepository facultyProfileRepository;

    public FacultyService(FacultyProfileRepository facultyProfileRepository) {
        this.facultyProfileRepository = facultyProfileRepository;
    }

    public FacultyProfile getFacultyProfileById(Long id) {
        return facultyProfileRepository.findById(id).orElse(null);
    }

    public void updateProfile(FacultyProfile facultyProfile) {
        facultyProfileRepository.save(facultyProfile);
    }
}
