package com.rajat.employeemanagement.Repository;

import com.rajat.employeemanagement.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

