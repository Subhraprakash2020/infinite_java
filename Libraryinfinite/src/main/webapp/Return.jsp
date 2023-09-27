<%-- <%@page import="com.java.library.BookReturn"%>
<%@page import="com.java.library.LibraryDAOImpl"%>
<%@page import="java.util.List"%>
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
    LibraryDAOImpl dao = new LibraryDAOImpl();
    List<BookReturn> bookList = dao.showReturn(userName);
  %>
   <form action="Return_Book.jsp">
        <table border="3" align="center">
            <tr>
                <th>UserName</th>
                <th>BookId</th>
                <th>From Date</th>
                <th>To Date</th>
                <th>Issue</th>
            </tr>
            <%
            for (BookReturn book : bookList) {
            %>
            <tr>
                <td><%=book.getUserName()%></td>
                <td><%=book.getBookId()%></td>
                <td><%=book.getFromDate()%></td>
                <td><%=book.getToday()%></td>
               
                <td><input type="checkbox" id="check<%=book.getBookId()%>" name="box" value="<%=book.getBookId()%>"></td>
                
            </tr>
            <%
            }
            %>
        </table>
        <input type="submit" value="Return Book(s)" />
    </form>
</body>
</html>
 --%>
 <%@page import="com.java.library.BookReturn"%>
<%@page import="com.java.library.LibraryDAOImpl"%>
<%@page import="java.util.List"%>
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
    LibraryDAOImpl dao = new LibraryDAOImpl();
    List<BookReturn> bookList = dao.showReturn(userName);
  %>
 <div class = "con">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <form action="Return_Book.jsp">
                    <table border="3" align="center">
                        <thead>
                        <tr>
                            <th>UserName</th>
                            <th>BookId</th>
                            <th>From Date</th>
                            <th>To Date</th>
                            <th>Issue</th>
                        </tr>
                    </thead>
                        <%
                        for (BookReturn book : bookList) {
                        %>
                        <tr>
                            <td><%=book.getUserName()%></td>
                            <td><%=book.getBookId()%></td>
                            <td><%=book.getFromDate()%></td>
                            <td><%=book.getToday()%></td>
                           
                            <td><input type="checkbox" id="check<%=book.getBookId()%>" name="box" value="<%=book.getBookId()%>"></td>
                            
                        </tr>
                        <%
                        }
                        %>
                    </table>
                    <input type="submit"  id = "issue" value="Return Book(s)" />
                </form>
            </div>
        </div>
    </div>
 </div>
</body>
</html>
 