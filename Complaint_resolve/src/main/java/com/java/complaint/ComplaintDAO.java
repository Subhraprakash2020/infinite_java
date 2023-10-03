package com.java.complaint;

import java.sql.SQLException;
import java.util.*;

public interface ComplaintDAO {
	String addComplaint(Complaint complaint) throws ClassNotFoundException, SQLException;
	Complaint searchComplaint(String complaintId) throws ClassNotFoundException, SQLException;
	List<Complaint> showComplaint() throws ClassNotFoundException, SQLException;
//	Complaint seatchComplaint(String complaintId, String ResolveBy, String Comments) throws ClassNotFoundException, SQLException;
	String addResolve(Resolve resolve, String complaintId, String status, Date ComplaintDate) throws ClassNotFoundException, 
	SQLException;
	
	List<Resolve> showResolve();
	
	
}
