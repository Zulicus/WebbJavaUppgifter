<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="cookies.CookieBean"%>
<!DOCTYPE html>
<!-- Imports the bean containing the cookie data -->
<%CookieBean cookie = (CookieBean) request.getAttribute("cookieBean");%>
<html>
<head>
<jsp:include page="components/headinfo.jsp" />
<title>Skånetrafiken - Sökningar</title>
</head>
<body id="page-top">
	<!-- Page Wrapper -->
	<div id="wrapper">
		<!-- Sidebar -->
		<jsp:include page="components/sidebar.jsp" />
		<!-- End of Sidebar -->
		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<!-- Main Content -->
			<div id="content"><jsp:include page="components/topbar.jsp"/>
				<!-- Add content here! -->
				<div class="container">
				<!-- Sends the "previous search" back to the servlet that'll find a rout -->
					<form action="<%=request.getContextPath()%>/ResultServlet" method="post">
						<div class="row">
							<div class="col">
								<ul style="list-style-type:none">
									<%for(int i=0;i<cookie.getFrom_Cookies().size();i++){%><li><input type="radio" name="from" value="<%= cookie.getFrom_Cookies().get(i).toLowerCase()%>"> <%= cookie.getFrom_Cookies().get(i)%></li><%} %>
								</ul>
							</div>
							<div class="col">
								<ul style="list-style-type:none">
									<%for(int i=0;i<cookie.getTo_Cookies().size();i++){%><li><input type="radio" name="to" value="<%= cookie.getTo_Cookies().get(i).toLowerCase()%>"> <%= cookie.getTo_Cookies().get(i)%></li><%} %>
								</ul>
							</div>
						</div>
						<div class="row">
							<div class="col">
								<input type="submit" value="Kör">
							</div>	
						</div>
					</form>
				</div>
			</div>
			<!-- End of Main Content -->
			<jsp:include page="components/footer.jsp"/>
		</div>
		<!-- End of Content Wrapper -->
	</div>
	<!-- End of Page Wrapper -->
	<jsp:include page="components/bootstrap.jsp"/>
</body>
</html>