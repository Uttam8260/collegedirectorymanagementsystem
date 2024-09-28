package com.college.directory.controller;

import com.college.directory.entity.User;
import com.college.directory.service.AuthenticationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired 
    private final AuthenticationService authenticationService;

    public UserController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        User user = authenticationService.authenticate(username, password);
        if (user != null) {
            return "Login successful! Role: " + user.getRole();
        } else {
            return "Invalid credentials";
        }
    }
}
