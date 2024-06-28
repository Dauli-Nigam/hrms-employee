package com.example.hrms.employee.exception;

public class DuplicateEmployeeIdException extends RuntimeException {
    public DuplicateEmployeeIdException(String message){
        super(message);
    }
}
