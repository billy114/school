package com.example.school.controllers;

import com.example.school.DTOs.StudentDTO;
import com.example.school.models.Course;
import com.example.school.models.Student;
import com.example.school.repositories.StudentRepository;
import com.example.school.serviceImplem.StudentImplem;
import com.example.school.services.CourseService;
import com.example.school.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    CourseService courseService;

    @GetMapping("{id}")
    public ResponseEntity<?> getStudentById (@PathVariable Long id){
        Optional<Student> student = studentService.getStudentById(id);

        if (student.isPresent()) {
            return new ResponseEntity<>(
                    StudentDTO.createStudentDTO(student.get()),
                    HttpStatus.OK
            );
        }else {
            return new ResponseEntity<>(
                    "Student not found",
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @PostMapping
    public ResponseEntity<?> createStudent (@RequestBody Student student){
        Student savedStudent = studentService.createStudent(student);
        return new ResponseEntity<>(
                StudentDTO.createStudentDTO(savedStudent),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<?> getAllStudent(){
        List<Student> students = studentService.getAllStudents();
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student student : students){
            studentDTOS.add(StudentDTO.createStudentDTO(student));
        }
        return new ResponseEntity<>(
                studentDTOS,
                HttpStatus.OK
        );
    }

    @PostMapping("subscribe/{studentId}/{courseId}")
    public ResponseEntity<?> subscribeToCourse(@PathVariable Long studentId, @PathVariable Long courseId){
        Optional<Student> student = studentService.getStudentById(studentId);
        if (student.isEmpty())
            return new ResponseEntity<>(
                    "Student not found",
                    HttpStatus.NOT_FOUND
            );
        Optional<Course> course = courseService.getCourseById(courseId);
        if (course.isEmpty())
            return new ResponseEntity<>(
                    "Course not found",
                    HttpStatus.NOT_FOUND
            );

        return new ResponseEntity<>(
                studentService.subscribeToCourse(student.get(), course.get()),
                HttpStatus.OK
        );
    }
}
