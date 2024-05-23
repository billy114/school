package com.example.school.DTOs;

import com.example.school.models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDTO {

    private Long id;
    private String name;
    private int age;
    List<CourseDTO> courses = new ArrayList<>();

    public StudentDTO createStudentDTO(Student student){
        return null;
    }
}
