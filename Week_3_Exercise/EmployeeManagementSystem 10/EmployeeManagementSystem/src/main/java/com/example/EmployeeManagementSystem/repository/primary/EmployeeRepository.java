package com.example.EmployeeManagementSystem.repository.primary;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.EmployeeManagementSystem.dto.EmployeeProjectionDTO;
import com.example.EmployeeManagementSystem.model.primary.Employee;
import com.example.EmployeeManagementSystem.projection.EmployeeProjection;

@Repository
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

    @Query("SELECT e FROM Employee e")
    List<Employee> findAllWithBatchProcessing();

    List<Employee> findByDepartmentId(Long departmentId);

    @Query("UPDATE Employee e SET e.salary = ?2 WHERE e.id = ?1")
    void updateSalaryById(Long id, Double newSalary);


}

