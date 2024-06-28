package com.example.hrms.employee.exception;

public class ApplicationDoesNotExistException extends RuntimeException{
    public ApplicationDoesNotExistException(String message){
        super(message);

    }
}
