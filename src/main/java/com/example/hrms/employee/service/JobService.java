package com.example.hrms.employee.service;

import com.example.hrms.employee.domain.Job;
import com.example.hrms.employee.repository.JobRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Getter
    private final JobRepository jobRepository;


    @Autowired
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;

    }

    public void createJob(Job job) {
        this.jobRepository.createJob(job);
    }


    public Job getJob(String jobId) {
        return this.jobRepository.getApplication(jobId);
    }


    public List<Job> getAllJobs() {
        return this.jobRepository.findAllJobs();
    }


}
