package com.example.hrms.employee.exception;

public class EmployeeDoesNotExistException extends RuntimeException{
    public EmployeeDoesNotExistException(String message){
        super(message);
    }
}
