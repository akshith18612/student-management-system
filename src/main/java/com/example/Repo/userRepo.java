package com.example.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Users;

@Repository
public interface userRepo extends JpaRepository<Users, Integer>{
    Users findByUsername(String username);
}
