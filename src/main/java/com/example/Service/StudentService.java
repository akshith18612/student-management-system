package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repo.departmentRepository;
import com.example.Repo.StudentRepo;
import com.example.model.Department;
import com.example.model.Student;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private departmentRepository departmentRepo;

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student addStudent(Student student, Long departmentId) {

        Department department = departmentRepo.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        student.setDepartment(department);

        return studentRepo.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }

    public Student getStudentById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    public Student updateStudent(Long id, Student updatedStudent) {

    Student student = studentRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Student not found"));

    student.setName(updatedStudent.getName());
    student.setEmail(updatedStudent.getEmail());
    student.setCourse(updatedStudent.getCourse());
    student.setAge(updatedStudent.getAge());

    return studentRepo.save(student);
}
}