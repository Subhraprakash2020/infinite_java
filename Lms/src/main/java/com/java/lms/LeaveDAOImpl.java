package com.java.lms;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;

public class LeaveDAOImpl implements LeaveDetailsDAO {

	Connection connection;
	PreparedStatement pst;
	
	public int dateDiff(Date startDate, Date endDate) {
		long ms = endDate.getTime() - startDate.getTime();
		int diff = (int)(ms/(1000 * 60 * 60 * 24));
		diff++;
		return diff;
	}
	
	@Override
	public String applyLeave(LeaveDetails leaveDetails) throws ClassNotFoundException, SQLException {
//		System.out.println(leaveDetails);
		connection = ConnectionHelper.getConnection();
		int diff = dateDiff(leaveDetails.getLeaveStartDate(), leaveDetails.getLeaveEndDate());
		Date currentDate = new Date(System.currentTimeMillis());
		 if (leaveDetails.getLeaveStartDate().before(currentDate)) {
		        return "Leave start date cannot be yesterday's date";
		    } else  if (leaveDetails.getLeaveEndDate().before(currentDate)) {
		        return "Leave end date cannot be yesterday's date";
		    } else  if (leaveDetails.getLeaveStartDate().after(leaveDetails.getLeaveEndDate())) {
		        return "Leave start date cannot be greater than leave end date";
		    }  else {
		 Employee employee = new EmployeeDAOImpl().searchEmployeeDao(leaveDetails.getEmpId());
		 int leaveAvailable = employee.getLeaveAvail();
		 
	     if (diff > leaveAvailable) {
	            return "No. of days of leave exceeds available leave balance.";
	        }
//		Date currentDate = new Date(0);
		leaveDetails.setNoOfDays(diff);
		String cmd = "Insert into LeaveDetails(EmpId,LeaveStartDate,LeaveEndDate,"
				+ "noOfDays,leaveType,leaveReason) values(?,?,?,?,?,?)";        pst = connection.prepareStatement(cmd);
		pst.setInt(1, leaveDetails.getEmpId());
		pst.setDate(2, leaveDetails.getLeaveStartDate());
		pst.setDate(3, leaveDetails.getLeaveEndDate());
		pst.setInt(4, leaveDetails.getNoOfDays());
		pst.setString(5, leaveDetails.getLeaveType().toString());
		pst.setString(6, leaveDetails.getLeaveReason());
		pst.executeUpdate();
		cmd = "Update Employee set LeaveAvail = LeaveAvail - ? Where EmpId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, diff);
		pst.setInt(2, leaveDetails.getEmpId());
		pst.executeUpdate();
		return "Leave Applied...";
		 }
	}

	@Override
	public String updateLeaveStatus(int leaveId, int ManagerId, String leaveStatus)
			throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();

	   
	    String cmd = "SELECT ManagerId FROM Employee WHERE EmpId = ?";
	    pst = connection.prepareStatement(cmd);
	    pst.setInt(1, ManagerId);
	    ResultSet manager = pst.executeQuery();

	    if (manager.next()) {
	        int managerIdFromDB = manager.getInt("ManagerId");

	        if (managerIdFromDB == leaveId) {
	            // Manager is authorized to approve leave
	            cmd = "UPDATE LeaveDetails SET LeaveStatus = ? WHERE LeaveId = ?";
	            pst = connection.prepareStatement(cmd);
	            pst.setString(1, leaveStatus);
	            pst.setInt(2, leaveId);
	            int updatedRows = pst.executeUpdate();

	            if (updatedRows > 0) {
	                return "Leave status updated successfully.";
	            } else {
	                return "Failed to update leave status.";
	            }
	        } else {
	            return "Manager is not authorized ";
	        }
	    } else {
	        return "Manager not found.";
	    }
		
		
	}
}
//	@Override
//	public String updateLeaveStatus(int leaveId, int ManagerId , String leaveStatus) throws ClassNotFoundException, SQLException {
//		// TODO Auto-generated method stub
//		connection = ConnectionHelper.getConnection();
//		
//		String cmd = "SELECT CASE \r\n"
//				+ "           WHEN ManagerId IS NULL THEN 'No Manager Assigned'\r\n"
//				+ "           ELSE 'Manager Assigned'\r\n"
//				+ "       END AS ManagerAssignmentStatus\r\n"
//				+ "FROM employees\r\n"
//				+ "WHERE leaveId = ?";
//		pst = connection.prepareStatement(cmd);
//		
//		pst.setInt(1, leaveId);
//		ResultSet rs = pst.executeQuery();
//		if(rs.next()) {
//			int managerStatus = rs.getInt(ManagerId);
//			if("Manager Assigned".equals(managerStatus)) {
//				String update = "UPDATE leave_table SET status = 'approved' WHERE leveId = ? AND managerId = ?";
//				pst = connection.prepareStatement(cmd);
//				pst.setInt(1, leaveId);
//				pst.setInt(2, ManagerId);
//				pst.executeUpdate();
//				return"leave status approved";
//				
//			}
//			else {
//				return "No mangger assign";
//			}
//			
//		}
//		else {
//			return"Employ not found";
//		}
//		
//		
//		
//	}
//
//	
//	
//}


