package com.first.student_Management_System.controller;

import com.first.student_Management_System.entity.Student;
import com.first.student_Management_System.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Correct import for Spring's Model
import org.springframework.web.bind.annotation.*;

@Controller

public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Handler method
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students"; // The name of the Thymeleaf template or view
    }
    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "create_student";

    }
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

   @GetMapping("/students/edit/{id}")
    public String  editStudentForm(@PathVariable Long  id ,Model model){
        model.addAttribute("student",studentService.getStudentById(id));
        return "edit_student";

   }
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student,Model model) {

        Student existingStudent =studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName((student.getLastName()));
        existingStudent.setEmail(student.getEmail());

        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }
    @GetMapping("students/{id}")
    public  String deleteStudent(@PathVariable Long id){
          studentService.deleteStudentById(id);
        return "redirect:/students";
    }

}
