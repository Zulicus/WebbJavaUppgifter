<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Uppgift 2</title>
</head>
<body>
	<div>
		<form action="<%=request.getContextPath()%>/List" method="get">
			<p>What do you want in your list?</p>
			<select name="subject">
				<option value="cat">Cats</option>
				<option value="dog">Dogs</option>
			</select>
			<p>And How many do you want?</p>
			<input type="number" name="amount" required>
			<input type="submit" value="Submit">
		</form>
	</div>
</body>
</html>