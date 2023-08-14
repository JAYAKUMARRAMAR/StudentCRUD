package com.youtube.student.service;

import com.youtube.student.model.Student;
import com.youtube.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getStudents(){
        return (List<Student>) studentRepository.findAll();
    }

}
