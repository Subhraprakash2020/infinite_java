<%-- <%@page import="com.java.library.LibUser"%>
<%@page import="com.java.library.LibraryDAOImpl"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
/*     String userName = request.getParameter("userName");
 */    out.println(userName);
    List<LibUser> bookList = dao.showHistory(userName);
    %>

    <form action="History.jsp">
        <table border="3" align="center">
            <tr>
                <th>UserName</th>
                <th>BookId</th>
                <th>From Date</th>
            </tr>
            <%
            for (LibUser user : bookList) {
            %>
            <tr>
                <td><%= user.getUserName() %></td>
                <td><%= user.getBookId() %></td>
                <td><%= user.getFromDate() %></td>
            </tr>
            <%
            }
            %>
        </table>
        
        <input type="submit" value="Issue Book(s)" />
    </form>
</body>
</html>
 --%>

<%@page import="com.java.library.LibUser"%>
<%@page import="com.java.library.LibraryDAOImpl"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Menu.css">
</head>
<body>
	<jsp:include page="Menu.jsp" />
	<%
	String userName = (String) session.getAttribute("user");
	LibraryDAOImpl dao = new LibraryDAOImpl();
	/*     String userName = request.getParameter("userName");
	 */ out.println(userName);
	List<LibUser> bookList = dao.showHistory(userName);
	%>
	<div class="con">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<form action="History.jsp">
						<table class="table table-bordered table-striped" align="center">
						 <thead>
							<tr>
								<th>UserName</th>
								<th>BookId</th>
								<th>From Date</th>
							</tr>
							</thead>
							<%
							for (LibUser user : bookList) {
							%>
							<tr>
								<td><%=user.getUserName()%></td>
								<td><%=user.getBookId()%></td>
								<td><%=user.getFromDate()%></td>
							</tr>
							<%
							}
							%>
							
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
