package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.StudentService;
import com.example.model.Student;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    @GetMapping("/csrf-token")

    public CsrfToken getcsrftoken(HttpServletRequest request) {
        return (CsrfToken)request.getAttribute("_csrf");
    }
    

    @PostMapping("/students")
    public void addStudent(@RequestBody Student student){
        studentService.AddStudent(student);
    }

    @PutMapping("/students/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody Student student){
        student.setId(id);
        studentService.updateStudent(student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }
}