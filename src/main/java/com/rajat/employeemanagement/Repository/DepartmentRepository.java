package com.rajat.employeemanagement.Repository;

import com.rajat.employeemanagement.Model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DepartmentRepository extends MongoRepository<Department, Integer> {
    List<Department> findByDepartmentName(String departmentName);
}


