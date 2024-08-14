package com.example.EmployeeManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.EmployeeManagementSystem.dto.EmployeeProjectionDTO;
import com.example.EmployeeManagementSystem.model.primary.Employee;
import com.example.EmployeeManagementSystem.projection.EmployeeProjection;
import com.example.EmployeeManagementSystem.repository.primary.EmployeeRepository;

import jakarta.persistence.EntityManager;



@Service
public class EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    @Autowired
    private EntityManager entityManager;

     public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeProjection> getEmployeeProjections() {
        return employeeRepository.findEmployeeProjections();
    }

    public List<EmployeeProjectionDTO> getEmployeeProjectionDTOs() {
        return employeeRepository.findEmployeeProjectionDTOs();
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }


    public Page<Employee> getEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }


    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional
    public void batchInsertEmployees(List<Employee> employees) {
        int batchSize = 20;
        for (int i = 0; i < employees.size(); i++) {
            entityManager.persist(employees.get(i));
            // Batch flush and clear
            if (i % batchSize == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
        entityManager.flush();  // Final flush to persist remaining entities
        entityManager.clear();
    }

     public List<Employee> getEmployeesByDepartment(Long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }

    // Check if Employee exists
    public boolean employeeExists(Long id) {
        return employeeRepository.existsById(id);
    }

    // Partial update on Employee's salary
    @Transactional
    public Optional<Employee> updateEmployeeSalary(Long id, Double newSalary) {
        Optional<Employee> employeeOpt = employeeRepository.findById(id);
        if (employeeOpt.isPresent()) {
            Employee employee = employeeOpt.get();
            employee.setSalary(newSalary);
            entityManager.merge(employee);  // Use merge for partial updates
        }
        return employeeOpt;
    }


}
