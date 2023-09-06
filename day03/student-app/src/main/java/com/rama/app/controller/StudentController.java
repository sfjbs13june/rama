package com.rama.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/getstudent")

    public String getStudentDetail(){
        return "student1";
    }
}
