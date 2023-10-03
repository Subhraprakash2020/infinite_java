<%@page import="com.java.complaint.Resolve"%>
<%@page import="java.util.List"%>
<%@page import="com.java.complaint.ComplaintDAOImpl"%>
<%@page import="com.java.complaint.ComplaintDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Complaint Resolutions</title>
</head>
<body>
<%
    ComplaintDAO dao = new ComplaintDAOImpl();
    List<Resolve> resolveList = dao.showResolve();
%>
<table border="3" align="center">
    <tr>
        <th>Resolve Id</th>
        <th>Complaint Id</th>
        <th>Complaint Date</th>
        <th>Resolve Date</th>
        <th>Resolved By</th>
        <th>Comments</th>
    </tr>
    <%
    for (Resolve resolve : resolveList) {
        java.util.Date complaintDate = resolve.getComplaintDate();
        java.util.Date resolveDate = resolve.getResolveDate();
        long diffInMilliseconds = resolveDate.getTime() - complaintDate.getTime();
        long diffInDays = diffInMilliseconds / (1000 * 60 * 60 * 24);
        
        // Define default row style
        String rowStyle = "";

        // Check the date difference and set row style accordingly
        if (diffInDays >= 7 && diffInDays < 10) {
            rowStyle = "background-color: pink;";
        } else if (diffInDays >= 10) {
            rowStyle = "background-color: red;";
        }
    %>
    <tr style="<%=rowStyle%>">
        <td><%=resolve.getResolveID()%></td>
        <td><%=resolve.getComplaintID()%></td>
        <td><%=resolve.getComplaintDate()%></td>
        <td><%=resolve.getResolveDate()%></td>
        <td><%=resolve.getResolveBy()%></td>
        <td><%=resolve.getComments()%></td>
    </tr>
    <%
    }
    %>
</table>
<a href = "ComplaintApply.jsp">Complaint Apply</a>
<a href = "ComplaintShow.jsp">Complaint Show</a>
</body>
</html>
