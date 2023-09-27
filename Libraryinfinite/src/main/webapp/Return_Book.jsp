<%@page import="com.java.library.LibraryDAOImpl"%>
<%@page import="com.java.library.LibraryDAO"%>
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
  String userName = (String) session.getAttribute("user");
  LibraryDAO dao = new LibraryDAOImpl();
  String[] butarr = request.getParameterValues("box");
  out.println("butarr"+butarr);
  if (butarr != null) {
      for (String bookId : butarr) {
          String result = dao.returnBook( bookId);
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