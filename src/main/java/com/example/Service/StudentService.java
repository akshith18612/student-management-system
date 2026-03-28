package com.example.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repo.StudentRepo;
import com.example.model.Student;
@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }
    public void AddStudent(Student student){
        studentRepo.save(student);
    }
    public void deleteStudent(Long id){
        studentRepo.deleteById(id);
    }
    public Student getStudentById(Long id){
        return studentRepo.findById(id).orElse(null);
    }
    public void updateStudent(Student student){
        
        studentRepo.save(student);
        
    }
    

}
