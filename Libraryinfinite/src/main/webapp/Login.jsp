<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <link rel="stylesheet" href="Login.css">
 -->
<title>Insert title here</title>
</head>
<body>
	<div class="container" id="container">
		<div class="form-container sign-up-container">
			<form method="post" action="Login.jsp">
				<div class="form-container sign-in-container">
					User Name : <input type="text" name="userName" placeholder = "User Name"/><br>
					Password : <input type="password" name="password" /><br> <input
						type="submit" value="Login" />
				</div>

			</form>
			
			<c:if test="${param.userName != null && param.password != null }">
				<jsp:useBean id="login" class="com.java.library.LibUsers" />
				<jsp:setProperty property="*" name="login" />
				<jsp:useBean id="dao" class="com.java.library.LibraryDAOImpl" />
				<c:set var="count" value="${dao.authenticate(login)}" />
				<c:if test="${count==1}">
					<%
					session.setAttribute("user", request.getParameter("userName"));
					%>
					<jsp:forward page="Menu.jsp" />
				</c:if>
				<c:if test="${count==0}">
					<c:out value="Invalid Credentials..." />
				</c:if>
			</c:if>
		</div>
	</div>

</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Login.css">

<title>Insert title here</title>
</head>
<body>
	<div class="container" id="container">
		<div class="form-container sign-up-container"></div>
		<div class="form-container sign-in-container">
			<form method="post" action="Login.jsp">
				<h1>Login</h1>
				 <input type="text" name="userName"
					placeholder="User Name" /><br> <input
					type="password" name="password" placeholder = "Password" /><br> <input type="submit"
					value="Login" id = "insubmit" />
			</form>
		</div>
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-left">
					<h1>Welcome Back!</h1>
					<p>To keep connected with us, please log in with your personal
						info</p>
					<button class="ghost" id="signIn">Sign In</button>
				</div>
				<div class="overlay-panel overlay-right">
					<h1>Hello, Friend!</h1>
					<p>Enter your personal details and start the journey with us</p>
					<a href = AddUser.jsp class="ghost">Sign Up</a>
				</div>
			</div>
		</div>
	</div>


	<c:if test="${param.userName != null && param.password != null }">
		<jsp:useBean id="login" class="com.java.library.LibUsers" />
		<jsp:setProperty property="*" name="login" />
		<jsp:useBean id="dao" class="com.java.library.LibraryDAOImpl" />
		<c:set var="count" value="${dao.authenticate(login)}" />
		<c:if test="${count==1}">
			<%
			session.setAttribute("user", request.getParameter("userName"));
			%>
			<jsp:forward page="Menu.jsp" />
		</c:if>
		<c:if test="${count==0}">
			<c:out value="Invalid Credentials..." />
		</c:if>
	</c:if>
</body>
</html>
