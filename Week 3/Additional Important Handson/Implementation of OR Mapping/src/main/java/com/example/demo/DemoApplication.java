package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private DepartmentRepository departmentRepo;

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private ProjectRepository projectRepo;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Department itDept = new Department("IT");
        Department hrDept = new Department("HR");
        departmentRepo.saveAll(Arrays.asList(itDept, hrDept));

        Project p1 = new Project("Alpha");
        Project p2 = new Project("Beta");
        projectRepo.saveAll(Arrays.asList(p1, p2));

        Employee e1 = new Employee("Alice");
        e1.setDepartment(itDept);
        e1.setProjects(new HashSet<>(Arrays.asList(p1, p2)));

        Employee e2 = new Employee("Bob");
        e2.setDepartment(hrDept);
        e2.setProjects(new HashSet<>(Arrays.asList(p2)));

        employeeRepo.saveAll(Arrays.asList(e1, e2));

        employeeRepo.findAll().forEach(System.out::println);
        projectRepo.findAll().forEach(p -> {
            System.out.println("Project: " + p.getProjectName() + ", Employees: " + p.getEmployees().size());
        });
    }
}
