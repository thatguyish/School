package com.thatguysapps.School.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
}
