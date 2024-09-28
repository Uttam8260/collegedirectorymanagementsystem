package com.college.directory.service;

import com.college.directory.entity.StudentProfile;
import com.college.directory.repository.StudentProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

	@Autowired
    private final StudentProfileRepository studentProfileRepository;

    
    public StudentService(StudentProfileRepository studentProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
    }

    public StudentProfile getStudentProfileById(Long id) {
        return studentProfileRepository.findById(id).orElse(null);
    }

    public List<StudentProfile> searchStudentsByName(String name) {
        return studentProfileRepository.findByNameContaining(name);
    }
}
