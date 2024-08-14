package com.example.EmployeeManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.EmployeeManagementSystem.dto.EmployeeProjectionDTO;
import com.example.EmployeeManagementSystem.model.primary.Employee;
import com.example.EmployeeManagementSystem.projection.EmployeeProjection;
import com.example.EmployeeManagementSystem.repository.primary.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

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

}
