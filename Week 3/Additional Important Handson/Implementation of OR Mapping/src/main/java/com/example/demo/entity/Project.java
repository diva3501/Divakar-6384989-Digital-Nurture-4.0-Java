package com.example.demo.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectName;

    @ManyToMany(mappedBy = "projects")
    private Set<Employee> employees = new HashSet<>();

    public Project() {}

    public Project(String projectName) {
        this.projectName = projectName;
    }

    public Long getId() { return id; }

    public String getProjectName() { return projectName; }

    public void setProjectName(String projectName) { this.projectName = projectName; }

    public Set<Employee> getEmployees() { return employees; }

    public void setEmployees(Set<Employee> employees) { this.employees = employees; }

    @Override
    public String toString() {
        return "Project [id=" + id + ", projectName=" + projectName + "]";
    }
}
