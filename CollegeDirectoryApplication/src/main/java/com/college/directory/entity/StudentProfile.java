package com.college.directory.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "student_profiles")
public class StudentProfile {

    @Id
    private Long userId;  // Same as User ID
    
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
    
    private String photo;
    
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;
    
    private String year;

    // Getters and setters...
}