package com.example.hrms.employee.repository;

import com.example.hrms.employee.domain.Employee;

import java.util.List;

public interface EmployeeRepository {
    void createEmployee(Employee employee);
    Employee getAccount(String employeeId);

    List<Employee> findAllEmployee();

    void clearEmployees();
}

