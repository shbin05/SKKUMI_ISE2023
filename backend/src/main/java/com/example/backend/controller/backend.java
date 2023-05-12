package com.example.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class backend {

    @GetMapping("/home")
    public String home() {
        return "Hello World!";
    }
}