package com.youtube.student.controller;

import org.junit.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youtube.student.model.Student;
import com.youtube.student.service.StudentService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class StudentControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Autowired
    private ObjectMapper objectMapper;

    // JUnit test for Get All employees REST API
    @Test
    public void givenListOfStudents_whenGetAllStudents_thenReturnStudentsList() throws Exception{
        // given - precondition or setup
        List<Student> listOfStudent = new ArrayList<>();
        listOfStudent.add(Student.builder().rollNumber(1).name("jaya").address("chennai").percentage(65.0).build());
        listOfStudent.add(Student.builder().rollNumber(2).name("jaya").address("chennai").percentage(65.0).build());
        given(studentService.getStudents()).willReturn(listOfStudent);

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/getStudents"));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(listOfStudent.size())));

    }
}
