package com.example.demo.repository;

import com.example.demo.dto.StudentCourseCountDTO;
import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    
    @Query("SELECT s FROM Student s WHERE s.email LIKE %:email%")
    List<Student> findByEmailContaining(@Param("email") String email);

    
    @Query("SELECT s FROM Student s JOIN FETCH s.courses WHERE s.name = :name")
    List<Student> fetchStudentWithCourses(@Param("name") String name);

    
    @Query("SELECT new com.example.demo.dto.StudentCourseCountDTO(s.name, COUNT(c)) " +
           "FROM Student s JOIN s.courses c GROUP BY s.name")
    List<StudentCourseCountDTO> countCoursesPerStudent();

    
    @Query(value = "SELECT * FROM student WHERE email = :email", nativeQuery = true)
    Student findByEmailNative(@Param("email") String email);
}
