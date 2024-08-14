package com.example.EmployeeManagementSystem.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.EmployeeManagementSystem.dto.EmployeeProjectionDTO;
import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.projection.EmployeeProjection;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartmentName(String departmentName);

    List<Employee> findBySalaryGreaterThan(Double salary);

    Page<Employee> findAll(Pageable pageable);

    @Query("SELECT e.id AS id, e.name AS name, e.email AS email, d.name AS departmentName " +
           "FROM Employee e JOIN e.department d")
    List<EmployeeProjection> findEmployeeProjections();
    @Query("SELECT new com.example.EmployeeManagementSystem.dto.EmployeeProjectionDTO(e.id, e.name, e.email, d.name) " +
           "FROM Employee e JOIN e.department d")
    List<EmployeeProjectionDTO> findEmployeeProjectionDTOs();

}
