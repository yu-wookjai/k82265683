package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoController {

    @GetMapping("/")
    public String home() {
        return "todoList";
    }
    
    @GetMapping("/api/v1/user")
    public String getUserId() {
            return "82058454"; // 사번
    }
}
