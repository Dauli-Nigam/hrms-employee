package com.example.hrms.employee.exception;

public class DuplicatePayslipIdException extends RuntimeException{

    public DuplicatePayslipIdException(String message){

        super(message);
    }
}
