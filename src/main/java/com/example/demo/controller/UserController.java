package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final String employeeNumber = "82262800";

    @GetMapping("/api/v1/user")
    public String getEmployeeNumber() {
        return employeeNumber;
    }
}
