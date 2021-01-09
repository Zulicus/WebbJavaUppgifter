<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
<%-- Main page where the user enters their credentials --%>
	<jsp:include page="header.jsp" />
	<form action="login.jsp">
		<ul class="list">
			<li><input type="text" name="Fname"> First Name</li>
			<li><input type="text" name="Lname"> Last Name</li>
			<li><input type="text" name="Uname"> User Name</li>
			<li><input type="password" name="Pword"> Password</li>
			<li><input type="text" name="Email"> E-mail</li>
		</ul>
		<input type="submit" value="Submit">
	</form>
	<jsp:include page="footer.jsp" />
</body>
</html>