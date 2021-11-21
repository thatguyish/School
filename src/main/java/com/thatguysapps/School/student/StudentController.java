package com.thatguysapps.School.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }
}
