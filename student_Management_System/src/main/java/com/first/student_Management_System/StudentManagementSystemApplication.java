package com.first.student_Management_System;

import com.first.student_Management_System.entity.Student;
import com.first.student_Management_System.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args -> {
			Student student1 = new Student(null, "Shehan", "Bandara", "shebanda12@gmail.com");
			studentRepository.save(student1);


		};
	}
}
