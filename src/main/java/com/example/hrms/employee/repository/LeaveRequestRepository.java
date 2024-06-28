package com.example.hrms.employee.repository;

import com.example.hrms.employee.domain.LeaveRequest;

import java.util.List;

public interface LeaveRequestRepository {


    void createLeaveRequest(LeaveRequest leaveRequest);

    LeaveRequest getLeaveRequest(String leaveRequestId);

    List<LeaveRequest> findAllLeaveRequest();

    void clearLeaveRequests();
}

