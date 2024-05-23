package com.example.school.DTOs;

import com.example.school.models.Course;
import com.example.school.models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDTO {

    private Long id;
    private String name;
    private int age;
    List<CourseDTO> courses = new ArrayList<>();

    public StudentDTO(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public StudentDTO(Long id, String name, int age, List<CourseDTO> courses) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.courses = courses;
    }

    public static StudentDTO createStudentDTO(Student student){
        List<CourseDTO> courseDTOS = new ArrayList<>();
        for (Course course : student.getCourses()){
            courseDTOS.add(
                    new CourseDTO(course.getId(), course.getName(), course.getDescription())
            );
        }

        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getAge(),
                courseDTOS
        );
    }
}
