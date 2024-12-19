package com.first.student_Management_System.repository;

import com.first.student_Management_System.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface StudentRepository extends JpaRepository<Student, Long> {
}
