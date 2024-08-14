package com.example.EmployeeManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EmployeeManagementSystem.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Derived query methods
    List<Employee> findByDepartmentId(Long departmentId);
    List<Employee> findByName(String name);
}