<%@page import="com.java.complaint.Complaint"%>
<%@page import="com.java.complaint.ComplaintDAO"%>
<%@page import="com.java.complaint.ComplaintDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="ComplaintApply.jsp">
		Complaint Type : <input type="text" name="complaintType"><br>
		<br> Complaint Description : <input type="text"
			name="cDescription"><br> <br> Severity : <input
			type="text" name="severity"><br> <br> <input
			type="submit" value="Apply">
	</form>
	
	<%
	  if(request.getParameter("complaintType")!= null && request.getParameter("cDescription") != null){
		  ComplaintDAO dao = new ComplaintDAOImpl();
		  Complaint complaint = new Complaint();
		  complaint.setComplaintType(request.getParameter("complaintType"));
		  complaint.setcDescription(request.getParameter("cDescription"));
		  complaint.setSeverity(request.getParameter("severity"));
		  dao.addComplaint(complaint);
		  %>
		  <jsp:forward page="ComplaintShow.jsp"/>
		  <%
	  }
	%>
<%-- 
	<%
	if (request.getParameter("complaintId") != null) {
	}
	%>

	<jsp:useBean id="complaint" class="com.java.complaint.Complaint" />
	<jsp:setProperty property="*" name="complaint" />

	<jsp:useBean id="dao" class="com.java.complaint.ComplaintDAOImpl" />

	<%
	String result = dao.addComplaint(complaint);
	out.print(result);
	%> --%>


</body>
</html>