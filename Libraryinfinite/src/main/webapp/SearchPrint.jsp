<%-- <!DOCTYPE html>
<%@page import="com.java.library.LibraryDAOImpl"%>
<%@page import="com.java.library.LibraryDAO"%>
<%@page import="com.java.library.Book"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <jsp:include page="Menu.jsp" />
    <%
    LibraryDAO dao = new LibraryDAOImpl();
    String searchType = request.getParameter("searchtype");
    String searchValue = request.getParameter("searchvalue");
    List<Book> booksList = dao.searchBooks(searchType, searchValue);
    %>
    <form action="Issue.jsp">
        <table border="3" align="center">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Author</th>
                <th>Edition</th>
                <th>Department</th>
                <th>Total Books</th>
                <th>Issue</th>
            </tr>
            <%
            for (Book book : booksList) {
            %>
            <tr>
                <td><%=book.getId()%></td>
                <td><%=book.getName()%></td>
                <td><%=book.getAuthor()%></td>
                <td><%=book.getEdition()%></td>
                <td><%=book.getDept()%></td>
                <td><%=book.getNoOfbook()%></td>
                <%
                if (book.getNoOfbook() != 0) {
                %>
                <td><input type="checkbox" id="check1" name="box" value="<%=book.getId()%>"></td>
                <%
                } else {
                %>
                <td></td>
                <%
                }
                %>
            </tr>
            <%
            }
            %>
        </table>
        <input type="submit" value="Issue Book()" />
    </form>
</body>
</html>
 --%>
 <!DOCTYPE html>
<%@page import="com.java.library.Book"%>
<%@page import="com.java.library.LibraryDAOImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.java.library.LibraryDAO"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Library Book Search</title>

    
</head>
<body>
 <jsp:include page="Menu.jsp" />
    <%
    LibraryDAO dao = new LibraryDAOImpl();
    String searchType = request.getParameter("searchtype");
    String searchValue = request.getParameter("searchvalue");
    List<Book> booksList = dao.searchBooks(searchType, searchValue);
    %>
    <div class = "con">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <form action="Issue.jsp">
                    <table class="table table-bordered table-striped" align="center">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Author</th>
                                <th>Edition</th>
                                <th>Department</th>
                                <th>Total Books</th>
                                <th>Issue</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                            for (Book book : booksList) {
                            %>
                            <tr>
                                <td><%=book.getId()%></td>
                                <td><%=book.getName()%></td>
                                <td><%=book.getAuthor()%></td>
                                <td><%=book.getEdition()%></td>
                                <td><%=book.getDept()%></td>
                                <td><%=book.getNoOfbook()%></td>
                                <%
                                if (book.getNoOfbook() != 0) {
                                %>
                                <td><input type="checkbox" id="check1" name="box" value="<%=book.getId()%>"></td>
                                <%
                                } else {
                                %>
                                <td></td>
                                <%
                                }
                                %>
                            </tr>
                            <%
                            }
                            %>
                        </tbody>
                    </table>
                    <input type="submit" class="btn btn-primary" id = "issue" value="Issue Book()" />
                </form>
            </div>
        </div>
    </div>
    </div>
    

    
</body>
</html>
 