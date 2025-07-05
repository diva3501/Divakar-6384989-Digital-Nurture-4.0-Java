package com.example.demo.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deptName;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<Employee> employees = new ArrayList<>();

    
    public Department() {}

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public Long getId() { return id; }

    public String getDeptName() { return deptName; }

    public void setDeptName(String deptName) { this.deptName = deptName; }

    public List<Employee> getEmployees() { return employees; }

    public void setEmployees(List<Employee> employees) { this.employees = employees; }

    @Override
    public String toString() {
        return "Department [id=" + id + ", deptName=" + deptName + "]";
    }
}
