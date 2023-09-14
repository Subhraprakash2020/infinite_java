package com.java.lms;

import java.sql.SQLException;

public interface LeaveDetailsDAO {
	String applyLeave(LeaveDetails leaveDetails) throws ClassNotFoundException, SQLException;
	LeaveDetails searchByLeaveId(int leaveId) throws ClassNotFoundException, SQLException;
	String approveDeny(int leaveId, int managerId, String status, String managerComments) 
			throws ClassNotFoundException, SQLException;
//	String updateLeaveStatus(int leaveId, int ManagerId , String leaveStatus ) throws ClassNotFoundException, SQLException;
}
