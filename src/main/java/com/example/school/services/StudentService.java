package com.example.school.services;

import com.example.school.models.Course;
import com.example.school.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();
    Student createStudent(Student student);
    Optional<Student> getStudentById(Long id);
    Student subscribeToCourse (Student student, Course course);
}
