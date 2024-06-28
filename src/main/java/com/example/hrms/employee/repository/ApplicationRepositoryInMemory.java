package com.example.hrms.employee.repository;

import com.example.hrms.employee.domain.Application;
import com.example.hrms.employee.exception.ApplicationDoesNotExistException;
import com.example.hrms.employee.exception.DuplicateApplicationIdException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ApplicationRepositoryInMemory implements ApplicationRepository {

    private final Map<String, Application> applicationMap = new ConcurrentHashMap<>();

    @Override
    public void createApplication(Application application) throws DuplicateApplicationIdException {
        Application previousApplication = applicationMap.putIfAbsent(application.getApplicationId(), application);
        if (previousApplication != null) {
            throw new DuplicateApplicationIdException(
                    "Application id " + application.getApplicationId() + "already exists");
        }
    }

    @Override
    public List<Application> findAllApplications() {
        return new ArrayList<>(applicationMap.values());
    }

    @Override
    public Application getApplication(String applicationId) {
        if (applicationMap.containsKey(applicationId)) {
            return applicationMap.get(applicationId);
        } else {
            throw new ApplicationDoesNotExistException("Application is not found");
        }
    }

    @Override
    public void clearApplications(){
        applicationMap.clear();
    }



}


