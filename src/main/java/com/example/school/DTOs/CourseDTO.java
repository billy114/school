package com.example.school.DTOs;

import com.example.school.models.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseDTO {
    private Long id;
    private String name;
    private String description;
    List<StudentDTO> students = new ArrayList<>();

    public CourseDTO createCourseDto (Course course){
        return null;
    }
}
