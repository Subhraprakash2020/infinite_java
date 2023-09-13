package com.java.leave;

import java.util.List;

public interface LeaveDAO {
	List<LeaveDetails> showLeaveDao();
	String addLeaveDao(LeaveDetails leave_details);
	LeaveDetails searchLeaveIdDao(int empno);
	String deleteLeaveIdDao(int empno);
	String updateLeaveIdDao(LeaveDetails updateLeaveId);
	
}
