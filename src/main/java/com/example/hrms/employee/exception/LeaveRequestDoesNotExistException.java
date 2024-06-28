package com.example.hrms.employee.exception;

public class LeaveRequestDoesNotExistException extends RuntimeException {

    public LeaveRequestDoesNotExistException(String message){
        super(message);

    }

}
