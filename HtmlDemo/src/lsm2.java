	@Override
	public String approveDeny(int leaveId, int managerId, String status, String managerComments) 
			throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		LeaveDetails leaveFound = searchByLeaveId(leaveId);
		int empId = leaveFound.getEmpId();
		EmployeeDAO dao = new EmployeeDAOImpl();
		Employee employee = dao.searchEmployeeDao(empId);
		int mgrId = employee.getManagerId();
		if (managerId==mgrId) {
			String cmd = "UPDATE LeaveDetails SET LeaveStatus = ?, ManagerComments = ? WHERE LeaveId = ?";
	        pst = connection.prepareStatement(cmd);
	        pst.setString(1, status);
	        pst.setString(2, managerComments);
	        pst.setInt(3, leaveId);
	        int updatedRows = pst.executeUpdate();

	        if (updatedRows > 0) {
	            return "Leave status updated successfully.";
	        } else {
	            return "Failed to update leave status.";
	        }
	
		} else {
			return "You are un-authoried...";
		}
		
	}