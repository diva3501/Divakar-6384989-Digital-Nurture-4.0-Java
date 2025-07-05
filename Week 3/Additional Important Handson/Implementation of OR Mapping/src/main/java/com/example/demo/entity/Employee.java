package com.example.demo.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dept_id")
    private Department department;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "employee_project",
               joinColumns = @JoinColumn(name = "employee_id"),
               inverseJoinColumns = @JoinColumn(name = "project_id"))
    private Set<Project> projects = new HashSet<>();

    public Employee() {}

    public Employee(String name) {
        this.name = name;
    }

    public Long getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Department getDepartment() { return department; }

    public void setDepartment(Department department) { this.department = department; }

    public Set<Project> getProjects() { return projects; }

    public void setProjects(Set<Project> projects) { this.projects = projects; }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", department=" + department.getDeptName() + "]";
    }
}
