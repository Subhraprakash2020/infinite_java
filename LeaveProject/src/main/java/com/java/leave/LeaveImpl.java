package com.java.leave;

import java.util.ArrayList;
import java.util.List;

public class LeaveImpl implements LeaveDAO {

    static List<LeaveDetails> leaveList;

    static {
        leaveList = new ArrayList<LeaveDetails>();
    }

    @Override
    public List<LeaveDetails> showLeaveDao() {
        return leaveList;
    }

    public int generateLeaveID() {
        if (leaveList.size() == 0) {
            return 1;
        } else {
            return leaveList.get(leaveList.size() - 1).getLeaveId() + 1;
        }
    }

    @Override
    public String addLeaveDao(LeaveDetails leave_details) {
        int leaveId = generateLeaveID();
        leave_details.setLeaveId(leaveId); // Set the generated leave ID
        leaveList.add(leave_details);
        return "Leave record inserted";
    }

    @Override
    public LeaveDetails searchLeaveIdDao(int empno) {
        for (LeaveDetails leave_details : leaveList) {
            if (leave_details.getEmpno() == empno) {
                return leave_details;
            }
        }
        return null; // Return null if not found
    }

    @Override
    public String deleteLeaveIdDao(int empno) {
        LeaveDetails leaveFound = searchLeaveIdDao(empno);
        if (leaveFound != null) {
            leaveList.remove(leaveFound);
            return "Leave application record deleted";
        }
        return "Application not found";
    }

    @Override
    public String updateLeaveIdDao(LeaveDetails updateLeaveId) {
        LeaveDetails leaveFound = searchLeaveIdDao(updateLeaveId.getEmpno());
        if (leaveFound != null) {
            // Update the existing leave application
            leaveFound.setEmpno(updateLeaveId.getEmpno());
            leaveFound.setName(updateLeaveId.getName());
            leaveFound.setLeaveStartDate(updateLeaveId.getLeaveStartDate());
            leaveFound.setLeaveEndDate(updateLeaveId.getLeaveEndDate());
            leaveFound.setLeaveType(updateLeaveId.getLeaveType());
            return "Leave application updated";
        }
        return "Leave application not found";
    }
}
