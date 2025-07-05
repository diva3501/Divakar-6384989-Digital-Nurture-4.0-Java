package com.example.demo.dto;

public class StudentCourseCountDTO {
    private String name;
    private Long courseCount;

    public StudentCourseCountDTO(String name, Long courseCount) {
        this.name = name;
        this.courseCount = courseCount;
    }

    // Getters/setters
    public String getName() { return name; }
    public Long getCourseCount() { return courseCount; }

    @Override
    public String toString() {
        return "Student: " + name + ", Courses: " + courseCount;
    }
}
