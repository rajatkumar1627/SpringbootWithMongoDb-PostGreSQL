package com.rajat.employeemanagement.service;

import com.rajat.employeemanagement.Model.Employee;
import com.rajat.employeemanagement.Repository.EmployeeRepository;
import com.rajat.employeemanagement.Service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static com.mongodb.assertions.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    void testGetEmployeeById() {
        // Arrange
        long employeeId = 1L;
        Employee mockEmployee = new Employee();
        mockEmployee.setId(employeeId);
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(mockEmployee));

        // Act
        Employee result = employeeService.getEmployeeById(employeeId);

        // Assert
        assertNotNull(result);
        assertEquals(employeeId, result.getId());
    }
}

