package com.college.directory.repository;

import com.college.directory.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query to find user by username and password for authentication
    User findByUsernameAndPassword(String username, String password);
}
