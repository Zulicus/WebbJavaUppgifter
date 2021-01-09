<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<%--Imports and displays the messages --%>
	<%
		String firstName = request.getParameter("Fname");
		String lastName = request.getParameter("Lname");
		String user = request.getParameter("Uname");
		String password = request.getParameter("Pword");
		String email = request.getParameter("Email");
		out.print("<p>Welcome " + firstName + " " + lastName + ", or whould we call you " + user + "?´</p>");
		out.print("<p>We've sent an e-mail confirmation request to " + email + "!</p>");
		out.print("<p>Please confirm your pasword</p>");
	%>
	<%--Where the password confirmation happens --%>
	<form action="mPages.jsp">
		<ul class="list">
			<li><input type="password" name="confirmedPassword">
				Password</li>
			<%--An invisible list element that forwards all the variables to the next page --%>
			<li><input type="hidden" name="Fname" value="<%=firstName%>" />
				<input type="hidden" name="Lname" value="<%=lastName%>" /> <input
				type="hidden" name="Uname" value="<%=user%>" /> <input
				type="hidden" name="Pword" value="<%=password%>" /> <input
				type="hidden" name="Email" value="<%=email%>" /></li>
		</ul>
		<input type="submit" value="Proceed to My Pages">
	</form>
	<jsp:include page="footer.jsp" />
</body>
</html>