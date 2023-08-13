package com.youtube.student.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    public String getName()
    {
        return "R JAYAKUMAR MCA";
    }
}
