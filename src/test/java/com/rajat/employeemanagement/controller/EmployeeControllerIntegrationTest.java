package com.rajat.employeemanagement.controller;

import com.rajat.employeemanagement.Model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetEmployeeById() {
        // Arrange
        long employeeId = 1L;

        // Act
        Employee response = restTemplate.getForObject("http://localhost:" + port + "/employees/" + employeeId, Employee.class);

        // Assert
        assertEquals(employeeId, response.getId());
    }
}

