package com.example.school.services;

import com.example.school.models.Course;
import java.util.List;
import java.util.Optional;

public interface CourseService {
    Optional<Course> getCourseById(Long id);
    List<Course> getAllCourses();
    Course createCourse (Course course);
    List<Course> filterPerWordInDescription(String word);
}
