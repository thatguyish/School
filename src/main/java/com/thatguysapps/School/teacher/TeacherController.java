package com.thatguysapps.School.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }

}