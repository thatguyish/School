package com.thatguysapps.School.subject;

import com.thatguysapps.School.student.Student;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    @JoinTable(name="student_enrolled",
            joinColumns = @JoinColumn(name="subject_id"),
            inverseJoinColumns = @JoinColumn(name="student_id"))
    private Set<Student> enrolledStudents = new HashSet<>();


    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

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
}
