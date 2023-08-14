package com.youtube.student.controller;

import com.youtube.student.model.Student;
import com.youtube.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public String getName()
    {
        return "R JAYAKUMAR MCA Welcome to FullStack Development";
    }

    @PostMapping("/registerStudent")
    public Student registerStudent(@RequestBody Student student) {
        return studentService.registerStudent(student);
    }

    @GetMapping("/getStudents")
    public List<Student> getStudents()
    {
        return studentService.getStudents();
    }
}
