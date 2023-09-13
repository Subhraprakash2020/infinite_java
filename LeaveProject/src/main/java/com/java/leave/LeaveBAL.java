package com.java.leave;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

public class LeaveBAL {
	static StringBuilder sb;
	static LeaveDAO dao;
	
	static {
		sb = new StringBuilder();
		dao = new LeaveImpl();
	}
	
	
	public String updateLeaveId(LeaveDetails leaveUpdate) throws LeaveException {
		if(validateLeave(leaveUpdate) == true ) {
			return dao.updateLeaveIdDao(leaveUpdate);
		}
		throw new LeaveException(sb.toString());
		
	}
	
	public String deleteLeaveId(int empno) {
		return dao.deleteLeaveIdDao(empno);
	}
	
	
	public LeaveDetails seatchLeaveId(int empno) {
		return dao.searchLeaveIdDao(empno);
	}
	
	public List<LeaveDetails> showLeaveBal(){
		return dao.showLeaveDao();
	}
	
	
	public String addLeaveBal(LeaveDetails leave_details) throws LeaveException {
		if(validateLeave(leave_details) == true) {
			return dao.addLeaveDao(leave_details);
		}
		throw new LeaveException(sb.toString());
		
		
	}
	
	
	public boolean validateLeave(LeaveDetails leave_details) {
		boolean flag = true;
	    Date startDate = leave_details.getLeaveStartDate();
	    Date endDate = leave_details.getLeaveEndDate();
	    Date currentDate = new Date();

	    // LeaveStartDate cannot be yesterday's date
	    if (startDate.before(currentDate)) {
	        flag = false;
	        sb.append("Start date cannot be a past date. ");
	    }

	    // LeaveEndDate cannot be yesterday's date
	    if (endDate.before(currentDate)) {
	        flag = false;
	        sb.append("End date cannot be a past date. ");
	    }

	    // LeaveEndDate should be greater than or equal to LeaveStartDate
	    if (endDate.before(startDate)) {
	        flag = false;
	        sb.append("End date should be greater than or equal to Start date. ");
	    }

	    // Calculate the number of days
	    long totalDays = calculateDateDifference(startDate, endDate);

	    // noOfDays cannot be more than 10
	    if (totalDays > 10) {
	        flag = false;
	        sb.append("Leave cannot be more than 10 days. ");
	    }

	    return flag;
	}
	private long calculateDateDifference(Date leaveStartDate, Date leaveEndDate) {
        long differenceInMillis = leaveStartDate.getTime() - leaveEndDate.getTime();
        return differenceInMillis / (24 * 60 * 60 * 1000);
    }
	
	
}
