package com.example.hrms.employee.exception;

public class DuplicateJobIdException extends RuntimeException{
    public DuplicateJobIdException(String message){
        super(message);
    }
}
