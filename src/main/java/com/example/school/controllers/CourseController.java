package com.example.school.controllers;

import com.example.school.models.Course;
import com.example.school.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        return new ResponseEntity<>(
                courseService.createCourse(course),
                HttpStatus.CREATED
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Long id){
        Optional<Course> course = courseService.getCourseById(id);
        if (course.isPresent()){
            return new ResponseEntity<>(
                    course.get(),
                    HttpStatus.OK
            );
        }else{
            return new ResponseEntity<>(
                    "Course not foound",
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses(){
        return new ResponseEntity<>(
                courseService.getAllCourses(),
                HttpStatus.OK
        );
    }

    @GetMapping("filter/{word}")
    public ResponseEntity<List<Course>> filterPerWordInDescription(@PathVariable String word){
        return new ResponseEntity<>(
                courseService.filterPerWordInDescription(word),
                HttpStatus.OK
        );
    }

}
