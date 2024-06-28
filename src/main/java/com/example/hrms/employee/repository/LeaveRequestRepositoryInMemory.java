package com.example.hrms.employee.repository;

import com.example.hrms.employee.domain.LeaveRequest;
import com.example.hrms.employee.exception.DuplicateLeaveRequestIdException;
import com.example.hrms.employee.exception.LeaveRequestDoesNotExistException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class LeaveRequestRepositoryInMemory implements LeaveRequestRepository {

    private final Map<String, LeaveRequest> leaveRequestMap = new ConcurrentHashMap<>();


    @Override
    public void createLeaveRequest(LeaveRequest leaveRequest) throws DuplicateLeaveRequestIdException {
        LeaveRequest previousLeaveRequest = leaveRequestMap.putIfAbsent(leaveRequest.getLeaveRequestId(), leaveRequest);
        if (previousLeaveRequest != null) {
            throw new DuplicateLeaveRequestIdException(
                    " LeaveRequest id " + leaveRequest.getLeaveRequestId() + "already exists");
        }
    }


    @Override
    public LeaveRequest getLeaveRequest(String leaveRequestId) {
        if (leaveRequestMap.containsKey(leaveRequestId)) {
            return leaveRequestMap.get(leaveRequestId);
        } else {
            throw new LeaveRequestDoesNotExistException("LeaveRequest is not found");
        }
    }


    @Override
    public List<LeaveRequest> findAllLeaveRequest() {
        return new ArrayList<>(leaveRequestMap.values());
    }

    @Override
    public void clearLeaveRequests() {
        leaveRequestMap.clear();
    }
}

