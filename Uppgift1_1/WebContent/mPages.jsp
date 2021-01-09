<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Pages</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<%--This is the "my pages" code that displays the users information --%>
	<% 
		String firstName = request.getParameter("Fname");
		String lastName = request.getParameter("Lname");
		String user = request.getParameter("Uname");
		String password = request.getParameter("Pword");
		String confirmedPassword= request.getParameter("confirmedPassword");
		String email = request.getParameter("Email");
		//If the passwords are the same the users personal information will show
		if(confirmedPassword.equals(password)){
			out.print("<h3>Hello "+user+"!</h3>");
			out.print("<p>Name: "+firstName+" "+lastName+"</p>");
			out.print("<p>E-mail: "+email+"</p>");
		//Otherwise they will have to go back using the navigationdropdown
		}else{
			out.print("<h2>Sorry Please Try Again!</h2>");
		}
	%>
	<jsp:include page="footer.jsp" />
</body>
</html>