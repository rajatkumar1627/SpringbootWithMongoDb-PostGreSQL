package com.rajat.employeemanagement.Service;

import com.rajat.employeemanagement.Model.Employee;
import com.rajat.employeemanagement.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long employeeId, Employee updatedEmployee) {
        if (employeeRepository.existsById(employeeId)) {
            updatedEmployee.setId(employeeId);
            return employeeRepository.save(updatedEmployee);
        }
        return null; // Employee not found, return appropriate response or throw an exception
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}


