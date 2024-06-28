package com.example.hrms.employee.repository;

import com.example.hrms.employee.domain.Payslip;

import java.util.List;

public interface PayslipRepository {

    void createPayslip(Payslip payslip);

    Payslip getPayslip(String payslipId);

    List<Payslip> findAllPayslip();

    void clearPayslips();

}
