package com.college.directory.repository;

import com.college.directory.entity.StudentProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {
    // Custom query to search for students by name
	@Query("select s from StudentProfile s where s.user.name=:name")
    List<StudentProfile> findByNameContaining(String name);
}
