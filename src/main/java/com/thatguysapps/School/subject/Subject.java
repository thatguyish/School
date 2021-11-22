package com.thatguysapps.School.subject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.thatguysapps.School.student.Student;
import com.thatguysapps.School.teacher.Teacher;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    @JsonIgnoreProperties("subjects")
    @JoinTable(name="student_enrolled",
            joinColumns = @JoinColumn(name="subject_id"),
            inverseJoinColumns = @JoinColumn(name="student_id"))
    private Set<Student> enrolledStudents = new HashSet<>();


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="teacher_id",referencedColumnName = "id")
    private Teacher teacher;


    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void enrollStudent (Student student){
        enrolledStudents.add(student);
    }

    public void assignTeacher (Teacher teacher){
        this.teacher = teacher;
    }

    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

}
