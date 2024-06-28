package com.example.hrms.employee.service;

import com.example.hrms.employee.domain.LeaveRequest;
import com.example.hrms.employee.repository.LeaveRequestRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveService {
    @Getter
    private final LeaveRequestRepository leaveRequestRepository;
    @Autowired
    public LeaveService(LeaveRequestRepository leaveRequestRepository) {
        this.leaveRequestRepository = leaveRequestRepository;
    }



    public void createLeaveRequest(LeaveRequest leaveRequest) {
        this.leaveRequestRepository.createLeaveRequest(leaveRequest);
    }

    public LeaveRequest getLeaveRequest(String leaveRequestId) {
        return this.leaveRequestRepository.getLeaveRequest(leaveRequestId);

    }
    public List<LeaveRequest> getAllLeaveRequests() {
        return this.leaveRequestRepository.findAllLeaveRequest();
    }
}

