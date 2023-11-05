package com.rajat.employeemanagement.Controller;

import com.rajat.employeemanagement.Model.Department;
import com.rajat.employeemanagement.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping("/addDepartment")
    public String saveDepartment(@RequestBody Department department){
        departmentRepository.save(department);
        return "Added book with id: " + department.getDepartmentId();
    }
    @GetMapping("/findAllDepartments")
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }
    @DeleteMapping("/delete/{departmentId}")
    public String deleteDepartment(@PathVariable int departmentId){
        departmentRepository.deleteById(departmentId);
        return "Record deleted successfully";
    }
}
