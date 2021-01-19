<%@page import="mvc.LoginBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%LoginBean bean = (LoginBean) request.getAttribute("LoginBean");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My pages</title>
</head>
<body>
	<div>
		<p>You are logged in, welcome <%=bean.getUser().getFirstName()%> <%=bean.getUser().getLastName()%>!</p>
		<p>Bio:	<%=bean.getUser().getBio()%></p>
		<form action="<%=request.getContextPath()%>/UpdatedBio" method="post">
			<textarea name="bio" rows="4" cols="50"></textarea>
			<input type="submit" value="Change Bio">
		</form>
		<form action="index.jsp" method="post">
			<input type="submit" value="Sign out">
		</form>
	</div>
</body>
</html>
