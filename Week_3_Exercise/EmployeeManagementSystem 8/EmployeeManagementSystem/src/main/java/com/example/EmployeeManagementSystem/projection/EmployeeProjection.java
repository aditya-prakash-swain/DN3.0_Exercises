package com.example.EmployeeManagementSystem.projection;

public interface EmployeeProjection {
    Long getId();
    String getName();
    String getEmail();
    String getDepartmentName(); // For a custom field
}
