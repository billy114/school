package com.example.school.controllers;

import com.example.school.models.Student;
import com.example.school.repositories.StudentRepository;
import com.example.school.serviceImplem.StudentImplem;
import com.example.school.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("{id}")
    public ResponseEntity<?> getStudentById (@PathVariable Long id){
        Optional<Student> student = studentService.getStudentById(id);

        if (student.isPresent()) {
            return new ResponseEntity<>(
                    student.get(),
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
                savedStudent,
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<?> getAllStudent(){
        return new ResponseEntity<>(
                studentService.getAllStudents(),
                HttpStatus.OK
        );
    }












}
