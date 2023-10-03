<%@page import="java.util.Date"%>
<%@page import="com.java.complaint.Resolve"%>
<%@page import="com.java.complaint.ComplaintDAO"%>
<%@page import="com.java.complaint.ComplaintDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resolve Complaint</title>
</head>
<body>
    <%
    String complaintId = request.getParameter("complaintId"); // Retrieve the complaintId from URL parameter
    if (complaintId != null) {
    %>
    <form method="post" action="ResolveComplaint.jsp">
        <input type="hidden" name="complaintId" value="<%=complaintId %>"><br>
        Resolve By: <input type="text" name="resolvedBy"><br>
        Comments: <input type="text" name="comments"><br> <input
            type="submit" value="Resolve">
    </form>

    <%
    if (request.getParameter("resolvedBy") != null && request.getParameter("comments") != null) {
        ComplaintDAO dao = new ComplaintDAOImpl();
        Resolve resolve = new Resolve();
        resolve.setComplaintID(complaintId);
        resolve.setResolveBy(request.getParameter("resolvedBy"));
        resolve.setComments(request.getParameter("comments"));

        String status = "Resolved"; // Set the status as resolved

        Date complaintDate = new Date(); // Use the current date

        String result = dao.addResolve(resolve, resolve.getComplaintID(), status, complaintDate);
        out.print(result);
        request.getRequestDispatcher("ResolveShow.jsp").forward(request, response);

        
    }
    %>  
    <%
    } else {
        out.print("Invalid URL parameters. Please provide a valid complaintId.");
    }
    %>
    
</body>
</html>
