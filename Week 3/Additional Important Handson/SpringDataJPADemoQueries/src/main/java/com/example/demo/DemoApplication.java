package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private CourseRepository courseRepo;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Course c1 = new Course("Java");
        Course c2 = new Course("Spring Boot");
        courseRepo.saveAll(Arrays.asList(c1, c2));

        Student s1 = new Student("Alice", "alice@example.com");
        Student s2 = new Student("Bob", "bob@domain.com");

        s1.getCourses().addAll(Arrays.asList(c1, c2));
        s2.getCourses().add(c2);

        studentRepo.saveAll(Arrays.asList(s1, s2));

        System.out.println("📌 Students with email like 'example':");
        studentRepo.findByEmailContaining("example").forEach(System.out::println);

        System.out.println("\n📌 Fetch with join fetch:");
        studentRepo.fetchStudentWithCourses("Alice").forEach(s -> {
            System.out.println(s.getName() + " -> " + s.getCourses().size() + " courses");
        });

        System.out.println("\n📌 Aggregate result:");
        studentRepo.countCoursesPerStudent().forEach(System.out::println);

        System.out.println("\n📌 Native query result:");
        System.out.println(studentRepo.findByEmailNative("alice@example.com"));
    }
}
