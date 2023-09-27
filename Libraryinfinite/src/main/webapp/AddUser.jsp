<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form metohd="post" action = "AddUser.jsp">
      User Name:
      <input type = "text" name = "userName"/><br>
      Password:
      <input type = "password" name = "password"/><br>
      Retype password:
      <input type = "password" name = "retypePassCode"/><br>
      <input type = "submit" value = "Create Account">
   </form>
   <c:if test = "${param.userName != null && param.password != null}">
    <c:if test = "${param.password == param.retypePassCode }">
      <jsp:useBean id = "libUsers" class = "com.java.library.LibUsers"/>
      <jsp:setProperty property="*" name="libUsers"/>
      <jsp:useBean id="beanDao" class = "com.java.library.LibraryDAOImpl"/>
      <%=beanDao.createUser(libUsers) %>
    </c:if>
   </c:if>
   
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
			<form metohd="post" action="AddUser.jsp">
				<h1>Sign In</h1>
				<input type="text" name="userName" placeholder="User Name" /><br>
				<input type="password" name="password" placeholder="Password" /><br>
				<input type="password" name="retypePassCode"
					placeholder="Retype Password" /><br> <input type="submit"
					value="Create Account"  id = "insubmit">
			</form>
		</div>
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-left">
					<h1>Welcome Back!</h1>
					<p>To keep connected with us, please log in with your personal
						info</p>
					
				</div>
				<div class="overlay-panel overlay-right">
					<h1>Hello, Friend!</h1>
					<p>Enter your personal details and start the journey with us</p>
					<a href = Login.jsp class="ghost">Login</a>
				</div>
			</div>
		</div>
	</div>


	<c:if test="${param.userName != null && param.password != null}">
		<c:if test="${param.password == param.retypePassCode }">
			<jsp:useBean id="libUsers" class="com.java.library.LibUsers" />
			<jsp:setProperty property="*" name="libUsers" />
			<jsp:useBean id="beanDao" class="com.java.library.LibraryDAOImpl" />
			<%=beanDao.createUser(libUsers)%>
		</c:if>
	</c:if>
</body>
</html>
