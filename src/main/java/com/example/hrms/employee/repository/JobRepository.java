package com.example.hrms.employee.repository;

import com.example.hrms.employee.domain.Job;

import java.util.List;

public interface JobRepository{

    void createJob(Job job);

    Job getApplication(String jobId);

    List<Job> findAllJobs();

    void clearJobs();
}

