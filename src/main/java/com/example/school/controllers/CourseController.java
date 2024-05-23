package com.example.school.controllers;

import com.example.school.DTOs.CourseDTO;
import com.example.school.models.Course;
import com.example.school.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping
    public ResponseEntity<?> createCourse(@RequestBody Course course){
        return new ResponseEntity<>(
                CourseDTO.createCourseDTO(courseService.createCourse(course)),
                HttpStatus.CREATED
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Long id){
        Optional<Course> course = courseService.getCourseById(id);
        if (course.isPresent()){
            return new ResponseEntity<>(
                    CourseDTO.createCourseDTO(course.get()),
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
    public ResponseEntity<?> getAllCourses(){

        return new ResponseEntity<>(
                map(courseService.getAllCourses()),
                HttpStatus.OK
        );
    }

    @GetMapping("filter/{word}")
    public ResponseEntity<?> filterPerWordInDescription(@PathVariable String word){
        return new ResponseEntity<>(
                map(courseService.filterPerWordInDescription(word)),
                HttpStatus.OK
        );
    }

    public List<CourseDTO> map (List<Course> courses){
        List<CourseDTO> res = new ArrayList<>();
        for (Course course : courses){
            res.add(CourseDTO.createCourseDTO(course));
        }
        return res;
    }

}
