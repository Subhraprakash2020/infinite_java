<%@page import="java.util.Date"%>
<%@page import="com.java.complaint.Complaint"%>
<%@page import="java.util.List"%>
<%@page import="com.java.complaint.ComplaintDAOImpl"%>
<%@page import="com.java.complaint.ComplaintDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	ComplaintDAO dao = new ComplaintDAOImpl();
	List<Complaint> complaintList = dao.showComplaint();
	%>
	<table border="3" align="center">
		<tr>
			<th>Complaint Id</th>
			<th>Complaint Type</th>
			<th>Complaint Description</th>
			<th>Complaint Date</th>
			<th>Severity</th>
			<th>Status</th>
			<th>Resolve</th>
		</tr>
		<%
		for (Complaint complaint : complaintList) {
		%>
		<tr>
			<td><%=complaint.getComplaintId()%></td>
			<td><%=complaint.getComplaintType()%></td>
			<td><%=complaint.getcDescription()%></td>
			<td><%=complaint.getComplaintDate()%></td>
			<td><%=complaint.getSeverity()%></td>
			<td><%=complaint.getStatus()%></td>

			<td><a href="ResolveComplaint.jsp?complaintId=<%=complaint.getComplaintId() %>&complaintdate=<%=complaint.getComplaintDate() %>
			&status=<%=complaint.getStatus() %>">Resolve</a></td>


		</tr>
		<%
		}
		%>

	</table>
	    <a href = "ComplaintApply.jsp">Apply Complaint</a>
	
</body>
</html>