package com.example.demo.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String email;

    @ManyToMany
    @JoinTable(name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses = new HashSet<>();

    public Student() {}
    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

}
