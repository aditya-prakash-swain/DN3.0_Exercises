package com.example.EmployeeManagementSystem.repository.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeManagementSystem.model.secondary.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}

