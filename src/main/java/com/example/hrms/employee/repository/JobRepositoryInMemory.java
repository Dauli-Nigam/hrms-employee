package com.example.hrms.employee.repository;

import com.example.hrms.employee.domain.Job;
import com.example.hrms.employee.exception.DuplicateJobIdException;
import com.example.hrms.employee.exception.JobDoesNotExistException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class JobRepositoryInMemory implements JobRepository{

    private final Map<String, Job>jobMap=new ConcurrentHashMap<>();

    @Override
    public void createJob(Job job) throws DuplicateJobIdException {
        Job previousJob=jobMap.putIfAbsent(job.getJobId(),job);
        if (previousJob!=null){
            throw new DuplicateJobIdException(
                    " Job id " + job.getJobId()+" already exists!");

        }
    }

    @Override
    public Job getApplication(String jobId) {
        if (jobMap.containsKey(jobId)){
            return jobMap.get(jobId);
        }else {
            throw new JobDoesNotExistException("Job is not found");
        }
    }

    @Override
    public List<Job> findAllJobs() {
        return new ArrayList<>(jobMap.values());
    }

    @Override
    public void clearJobs(){
        jobMap.clear();
    }
}

