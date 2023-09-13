@Override
public String approveDeny(int leaveId, int managerId, String status, String managerComments) 
        throws ClassNotFoundException, SQLException {
    connection = ConnectionHelper.getConnection();
    LeaveDetails leaveFound = searchByLeaveId(leaveId);
    int empId = leaveFound.getEmpId();
    EmployeeDAO dao = new EmployeeDAOImpl();
    Employee employee = dao.searchEmployeeDao(empId);
    int mgrId = employee.getManagerId();
    
    if (managerId == mgrId) {
        String cmd = "UPDATE LeaveDetails SET LeaveStatus = ?, ManagerComments = ? WHERE LeaveId = ?";
        pst = connection.prepareStatement(cmd);
        pst.setString(1, status);
        pst.setString(2, managerComments);
        pst.setInt(3, leaveId);
        
        int updatedRows = pst.executeUpdate();
        
        if (updatedRows > 0) {
            if ("Approved".equalsIgnoreCase(status)) {
                // Update leave balance for approved leave
                cmd = "UPDATE Employee SET LeaveAvail = LeaveAvail - ? WHERE EmpId = ?";
                pst = connection.prepareStatement(cmd);
                pst.setInt(1, leaveFound.getNoOfDays());
                pst.setInt(2, empId);
                pst.executeUpdate();
                
                return "Leave status updated to 'Approved', and leave balance updated.";
            } else if ("Rejected".equalsIgnoreCase(status)) {
                // Update leave balance for rejected leave
                cmd = "UPDATE Employee SET LeaveAvail = LeaveAvail + ? WHERE EmpId = ?";
                pst = connection.prepareStatement(cmd);
                pst.setInt(1, leaveFound.getNoOfDays());
                pst.setInt(2, empId);
                pst.executeUpdate();
                
                return "Leave status updated to 'Rejected', and leave balance updated.";
            } else {
                return "Invalid leave status. Please use 'Approved' or 'Rejected'.";
            }
        } else {
            return "Failed to update leave status.";
        }
    } else {
        return "You are unauthorized to approve or reject this leave.";
    }
}
