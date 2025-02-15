package com.example.hrms.employee.controller;
import com.example.hrms.employee.domain.Job;
import com.example.hrms.employee.service.JobService;
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
@RequestMapping("/api/recruitment")
@Api(value = "Recruitment API", description = "Used to adding and getting information of available job")
@Slf4j
public class JobController {

    private final JobService recruitmentService;

    @Autowired
    public JobController(JobService recruitmentService) {
        this.recruitmentService = recruitmentService;
    }


    @ApiOperation(value = "Posting a Job", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Job Posted successfully"),
            @ApiResponse(code = 400, message = "Invalid input provided"),
            @ApiResponse(code = 500, message = "Internal server error occurred")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createJob(@RequestBody @Valid Job job) {
        log.info("Posting a job {}", job);
        recruitmentService.createJob(job);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get a Job by Job id", response = Job.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the Job"),
            @ApiResponse(code = 400, message = "Invalid input provided"),
            @ApiResponse(code = 404, message = "Account not found"),
            @ApiResponse(code = 500, message = "Internal server error occurred")
    })
    @GetMapping(path = "/{jobId}")
    public Job getJob(@PathVariable String jobId) {
        log.info("Retrieving Job for id {}", jobId);
        return this.recruitmentService.getJob(jobId);
    }



    @ApiOperation(value = "Get all jobs", response = Job.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all Jobs"),
            @ApiResponse(code = 500, message = "Internal server error occurred")
    })
    @GetMapping
    public List<Job> getAllJobs() {
        log.info("Retrieving all jobs");
        return this.recruitmentService.getAllJobs();
    }



}


