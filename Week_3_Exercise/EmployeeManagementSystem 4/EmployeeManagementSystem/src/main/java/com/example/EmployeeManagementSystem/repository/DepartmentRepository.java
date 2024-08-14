package com.example.EmployeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EmployeeManagementSystem.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // Derived query methods
    Department findByName(String name);
}
