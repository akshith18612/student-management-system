package com.example.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.Department;

public interface departmentRepository
        extends JpaRepository<Department, Long> {
}