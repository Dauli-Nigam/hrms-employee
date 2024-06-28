package com.example.hrms.employee.controller;

import com.example.hrms.employee.domain.Application;
import com.example.hrms.employee.service.ApplicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/applications")
@Api(value = "Application API", description = "Used to adding information about application in HRMS")
@Slf4j
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @ApiOperation(value = "Creating an application", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Job Posted successfully"),
            @ApiResponse(code = 400, message = "Invalid input provided"),
            @ApiResponse(code = 500, message = "Internal server error occurred")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createApplication(@RequestBody @Valid Application application) {
        log.info("Creating application {}", application);
        applicationService.createApplication(application);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get an application by application id", response = Application.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the Application"),
            @ApiResponse(code = 400, message = "Invalid input provided"),
            @ApiResponse(code = 404, message = "Account not found"),
            @ApiResponse(code = 500, message = "Internal server error occurred")
    })
    @GetMapping(path = "/{applicationId}")
    public Application getApplication(@PathVariable String applicationId) {
        log.info("Retrieving Application for id {}", applicationId);
        return this.applicationService.getApplication(applicationId);
    }


    @ApiOperation(value = "Get all applications", response = Application.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all Jobs"),
            @ApiResponse(code = 500, message = "Internal server error occurred")
    })
    @GetMapping
    public List<Application> getAllApplications() {
        log.info("Retrieving all applications");
        return applicationService.getAllApplications();
    }}





