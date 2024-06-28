package com.example.hrms.employee.exception;

public class PayslipDoesNotExistException extends RuntimeException{

    public PayslipDoesNotExistException(String message){

        super(message);
    }
}
