package com.example.hrms.employee.repository;

import com.example.hrms.employee.domain.Application;
import com.example.hrms.employee.exception.DuplicateApplicationIdException;

import java.util.List;

public interface ApplicationRepository {

    void createApplication(Application application)throws DuplicateApplicationIdException;

    List<Application> findAllApplications();

    Application getApplication(String applicationId);

    void clearApplications();


}
