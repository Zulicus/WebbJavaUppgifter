<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Uppgift 3</title>
</head>
<body>
	<div>
	<%String tries=request.getParameter("tries");
	if(tries==null||Integer.parseInt(tries)<0){
		tries="0";
	}
	if(Integer.parseInt(tries)<5){%>
		<form action="<%=request.getContextPath()%>/Login" method="post">
			<p>Username:</p> <input name="username" type="text" required> 
			<p>Password:</p> <input name="password" type="password" required> 
			<p><input type="checkbox" required> I accept the terms and conditions</p>
			<input type="hidden" name="tries" value="<%=tries%>">
			<input type="submit" value="Log in">
		</form>
		<%}else{ %>
			<h2>Sorry, too many failed attempts</h2>
		<%} %>
	</div>
</body>
</html>