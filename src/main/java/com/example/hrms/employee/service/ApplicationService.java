package com.example.hrms.employee.service;

import com.example.hrms.employee.domain.Application;
import com.example.hrms.employee.repository.ApplicationRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Getter
    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }


    public void createApplication(Application application) {
        this.applicationRepository.createApplication(application);
    }

    public Application getApplication(String applicationId) {
        return this.applicationRepository.getApplication(applicationId);

    }

    public List<Application> getAllApplications() {
        return this.applicationRepository.findAllApplications();
    }
}

