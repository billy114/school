package com.example.school.DTOs;

import com.example.school.models.Course;
import com.example.school.models.Student;

import java.util.ArrayList;
import java.util.List;

public class CourseDTO {
    private Long id;
    private String name;
    private String description;
    List<StudentDTO> students = new ArrayList<>();

    public CourseDTO(Long id, String name, String description, List<StudentDTO> students) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.students = students;
    }

    public CourseDTO(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static CourseDTO createCourseDTO (Course course){
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student student : course.getStudents()){
            studentDTOS.add(
                    new StudentDTO(student.getId(), student.getName(), student.getAge())
            );
        }
        return new CourseDTO(
                course.getId(),
                course.getName(),
                course.getDescription(),
                studentDTOS
                );
    }
}
