package com.first.student_Management_System.service.impl;

import com.first.student_Management_System.entity.Student;
import com.first.student_Management_System.repository.StudentRepository;
import com.first.student_Management_System.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private  final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){

        return studentRepository.findAll();
    }
    public Student  saveStudent(Student student){
        return studentRepository.save(student);
    }
    public Student getStudentById(Long id){
      return studentRepository.findById(id).get();
    }
    public Student updateStudent(Student student){
        return studentRepository.save(student);

    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
