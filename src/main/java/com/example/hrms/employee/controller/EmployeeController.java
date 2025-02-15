package com.example.hrms.employee.controller;

import com.example.hrms.employee.domain.Employee;
import com.example.hrms.employee.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Api(value = "Employee API", description = "Used to adding information about employees in HRMS")
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @ApiOperation(value = "Create Employee", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Employee created successfully"),
            @ApiResponse(code = 400, message = "Invalid input provided"),
            @ApiResponse(code = 500, message = "Internal server error occurred")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createEmployee(@RequestBody @Valid Employee employee) {
        log.info("Creating Employee {}", employee);
        employeeService.createEmployee(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }







    @ApiOperation(value = "Get an Employee by Employee id", response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the Employee"),
            @ApiResponse(code = 400, message = "Invalid input provided"),
            @ApiResponse(code = 404, message = "Employee not found"),
            @ApiResponse(code = 500, message = "Internal server error occurred")
    })
    @GetMapping(path = "/{employeeId}")
    public Employee getEmployee(@PathVariable String employeeId) {
        log.info("Retrieving Employee for id {}", employeeId);
        return this.employeeService.getEmployee(employeeId);
    }








    @ApiOperation(value = "Get all Employees", response = Employee.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all Employee"),
            @ApiResponse(code = 500, message = "Internal server error occurred")
    })
    @GetMapping
    public List<Employee> getAllEmployees() {
        log.info("retrieving all employees");
        return employeeService.getAllEmployees();
    }
}