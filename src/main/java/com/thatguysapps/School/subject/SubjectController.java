package com.thatguysapps.School.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public List<Subject> getAllSubjects(){
        return subjectService.getAllSubjects();
    }

    @PostMapping
    Subject createSubject(@RequestBody Subject subject){
        return subjectService.createSubject(subject);
    }

    @PutMapping("/{subjectId}/students/{studentId}")
    Subject addStudentToSubject(@PathVariable Long subjectId, @PathVariable Long studentId){
        return subjectService.addStudentToSubject(subjectId, studentId);
    }

    @PutMapping("/{subjectId}/teacher/{teacherId}")
    Subject addTeacherToSubject(@PathVariable Long subjectId, @PathVariable Long teacherId){
        return subjectService.addTeacherToSubject(subjectId, teacherId);
    }

}
