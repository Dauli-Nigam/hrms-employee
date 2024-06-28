package com.example.hrms.employee.exception;

public class DuplicateLeaveRequestIdException extends RuntimeException{
    public DuplicateLeaveRequestIdException(String message){
        super(message);
    }
}
