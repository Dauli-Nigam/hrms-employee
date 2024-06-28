package com.example.hrms.employee.exception;

public class JobDoesNotExistException extends RuntimeException{
    public JobDoesNotExistException(String message){
        super(message);
    }
}
