<%@page import="org.apache.tomcat.jni.Library"%>
<%@page import="com.java.library.Book"%>
<%@page import="com.java.library.LibraryDAOImpl"%>
<%@page import="com.java.library.LibraryDAO"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Menu.jsp" />
    <%
    String user = (String) session.getAttribute("user");
    LibraryDAO dao = new LibraryDAOImpl();
    String[] butarr = request.getParameterValues("box");
    out.println("butarr"+butarr);
    if (butarr != null) {
        for (String bookId : butarr) {
            String result = dao.issueBook(user, bookId);
            out.println(result);
            out.println("Sucess");
        }
    }
    else{
    	out.println("Not found");
    }
    %>
</body>
</html>
