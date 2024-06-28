package com.example.hrms.employee.repository;

import com.example.hrms.employee.domain.Payslip;
import com.example.hrms.employee.exception.DuplicatePayslipIdException;
import com.example.hrms.employee.exception.PayslipDoesNotExistException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PayslipRepositoryInMemory implements PayslipRepository {

    private final Map<String, Payslip> payslipMap = new ConcurrentHashMap<>();

    @Override
    public void createPayslip(Payslip payslip) throws DuplicatePayslipIdException {
        Payslip previousPayslip = payslipMap.putIfAbsent(payslip.getPayslipId(), payslip);
        if (previousPayslip != null) {
            throw new DuplicatePayslipIdException(
                    "Payslip id" + payslip.getPayslipId() + "already exists");
        }
    }

    @Override
    public Payslip getPayslip(String payslipId) {
        if (payslipMap.containsKey(payslipId)){
            return payslipMap.get(payslipId);
        }else {
            throw new PayslipDoesNotExistException("Payslip is not found");
        }
    }

    @Override
    public List<Payslip> findAllPayslip() {
        return new ArrayList<>(payslipMap.values());
    }

    @Override
    public void clearPayslips() {
        payslipMap.clear();
    }
}
