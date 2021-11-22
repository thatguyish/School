package com.thatguysapps.School.student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.thatguysapps.School.subject.Subject;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnoreProperties("enrolledStudents")
    @ManyToMany(mappedBy="enrolledStudents")
    private Set<Subject> subjects = new HashSet<>();


    private String name;

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
