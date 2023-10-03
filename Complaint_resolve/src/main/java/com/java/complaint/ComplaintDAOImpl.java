package com.java.complaint;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComplaintDAOImpl implements ComplaintDAO{
	
	Connection connection;
	PreparedStatement pst;

	@Override
	public String addComplaint(Complaint complaint) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String getMaxStockIdQuery = "SELECT MAX(ComplaintID) FROM Complaint";
		pst = connection.prepareStatement(getMaxStockIdQuery);
		ResultSet resultSet = pst.executeQuery();
		 int maxStockId = 0;
         if (resultSet.next()) {
             String maxStockIdStr = resultSet.getString(1);
             if (maxStockIdStr != null && maxStockIdStr.matches("S\\d+")) {
                 maxStockId = Integer.parseInt(maxStockIdStr.substring(1));
             }
         }
         maxStockId++;
        String newCompId = String.format("S%03d", maxStockId);
		String cmd = "Insert into Complaint (ComplaintID, ComplaintType, CDescription, Severity, Status) values (?,?,?,?,?) ";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, newCompId);
		pst.setString(2, complaint.getComplaintType());
		pst.setString(3, complaint.getcDescription());
		pst.setString(4, complaint.getSeverity());
		pst.setString(5, "pending");
		pst.executeUpdate();
		return "Record Inserted";
		
		
	}

	@Override
	public Complaint searchComplaint(String complaintId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Select * from complaint where complaintId = ?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, complaintId);
		ResultSet rs = pst.executeQuery();
		Complaint complaint = null;
		if(rs.next()) {
			complaint = new Complaint();
			complaint.setComplaintId(rs.getString("complaintId"));
			complaint.setComplaintType(rs.getString("complaintType"));
			complaint.setcDescription(rs.getString("cDescription"));
			complaint.setComplaintDate(rs.getDate("ComplaintDate"));
			complaint.setSeverity(rs.getString("severity"));
			complaint.setStatus(rs.getString("status"));
		}
		
		return complaint;
	}

	@Override
	public List<Complaint> showComplaint() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Select * from Complaint";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Complaint> complaintList = new ArrayList<Complaint>();
		Complaint complaint = null;
		while(rs.next()) {
			String status = rs.getString("status");
			
			if(!"Resolved".equals(status)) {
				complaint = new Complaint();
				complaint.setComplaintId(rs.getString("complaintId"));
				complaint.setComplaintType(rs.getString("complaintType"));
				complaint.setcDescription(rs.getString("cDescription"));
				complaint.setComplaintDate(rs.getDate("ComplaintDate"));
				complaint.setSeverity(rs.getString("severity"));
				complaint.setStatus(rs.getString("status"));
				complaintList.add(complaint);
			}
			
		}
		return complaintList;
	}

	@Override
	public String addResolve(Resolve resolve, String complaintId, String status, Date complaintDate)
	        throws ClassNotFoundException, SQLException {
	    connection = ConnectionHelper.getConnection();
	    
	    // Retrieve the ComplaintDate from the original complaint
	    Complaint originalComplaint = searchComplaint(complaintId);
	    
	    if (originalComplaint == null) {
	        return "Complaint not found"; // Handle error gracefully
	    }

	    String getMaxStockIdQuery = "SELECT MAX(resolveId) FROM resolve";
		pst = connection.prepareStatement(getMaxStockIdQuery);
		ResultSet resultSet = pst.executeQuery();
		 int maxStockId = 0;
         if (resultSet.next()) {
             String maxStockIdStr = resultSet.getString(1);
             if (maxStockIdStr != null && maxStockIdStr.matches("R\\d+")) {
                 maxStockId = Integer.parseInt(maxStockIdStr.substring(1));
             }
         }
         maxStockId++;
        String newResolveId = String.format("R%03d", maxStockId);
	    String cmd = "INSERT INTO resolve(ResolveId,complaintId,complaintDate, resolvedBy, comments) VALUES(?,?,?,?,?)";
	    pst = connection.prepareStatement(cmd);
	    pst.setString(1, newResolveId);
	    pst.setString(2, complaintId);
	    pst.setDate(3, new java.sql.Date(originalComplaint.getComplaintDate().getTime())); // Use the original ComplaintDate
	    pst.setString(4, resolve.getResolveBy());
	    pst.setString(5, resolve.getComments());
	    pst.executeUpdate();

	    // Update the status in the Complaint table
	    String updateStatusSQL = "UPDATE Complaint SET Status = ? WHERE ComplaintID = ?";
	    pst = connection.prepareStatement(updateStatusSQL);
	    pst.setString(1, status);
	    pst.setString(2, complaintId);
	    pst.executeUpdate();

	    return "Resolution added and status updated";
	}

	@Override
	public List<Resolve> showResolve() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Select * from resolve";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Resolve> resolveList = new ArrayList<Resolve>();
		Resolve resolve = null;
		while(rs.next()) {
			resolve = new Resolve();
			resolve.setResolveID(rs.getString("resolveId"));
			resolve.setComplaintID(rs.getString("complaintId"));
			resolve.setComplaintDate(rs.getDate("complaintDate"));
			resolve.setResolveDate(rs.getDate("resolveDate"));
			resolve.setResolveBy(rs.getString("resolvedBy"));
			resolve.setComments(rs.getString("comments"));
			resolveList.add(resolve);
		}
		
		return resolveList;
	}

		
		
		



}
