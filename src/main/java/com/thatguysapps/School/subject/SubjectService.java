package com.thatguysapps.School.subject;

import com.thatguysapps.School.student.Student;
import com.thatguysapps.School.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Subject addStudentToSubject(Long subjectId, Long studentId) {
        Subject subject = subjectRepository.getById(subjectId);
        Student student = studentRepository.getById(studentId);

        subject.enrollStudent(student);
        return subjectRepository.save(subject);
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }
}
