package com.microservice.student.presentation.controller;

import com.microservice.student.application.service.StudentService;
import com.microservice.student.domain.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody  Student student){
        studentService.createStudent(student);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findAllStudent(){
        return ResponseEntity.ok(studentService.findAllStudents());
    }

    @PostMapping("/search/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.findById(id));
    }

    @GetMapping("/course/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findByIdCourse(@PathVariable Long id){
        return ResponseEntity.ok(studentService.findByIdCourse(id));
    }
}
