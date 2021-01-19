<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Uppgift 1</title>
</head>
<body>
	<div>
		<form action="<%=request.getContextPath()%>/Get" method="get">
			<p>First Name: </p> <input name="fname" type="text">
			<p>Last Name: </p> <input name="lname" type="text">
			<p>Country of residence: </p> <input name="country" type="text">
			<p><input type="submit" value="Submit"> </p>
		</form>
	</div>
</body>
</html>