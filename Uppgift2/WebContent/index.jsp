<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Start</title>
</head>
<body>
	<div>
		<form action="<%=request.getContextPath()%>/ControllerServlet" method="post">
			<ul class="list">
				<li><input type="text" name="username" required> User Name</li>
				<li><input type="password" name="password" required> Password</li>
			</ul>
			<input type="submit" value="Sign in">
		</form>
	</div>
</body>
</html>