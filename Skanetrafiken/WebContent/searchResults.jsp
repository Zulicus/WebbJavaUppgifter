<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="beans.SearchBean"%>
	<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
<!-- Import the bean from searchServlet -->
<%SearchBean search = (SearchBean) request.getAttribute("searchBean");%>
<head>
<jsp:include page="components/headinfo.jsp" />
    <title>Skånetrafiken - Sökresultat</title>
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
					<form action="<%=request.getContextPath()%>/ResultServlet" method="post">
						<div class="row">
							<div class="col">
								<ul style="list-style-type:none">
								<!-- Display all the results -->
									<%for(int i=0;i<search.getFromLoc().size();i++){%><li><input type="radio" name="from" value="<%= search.getFromLoc().get(i).toLowerCase()%>"> <%= search.getFromLoc().get(i)%></li><%} %>
								</ul>
							</div>
							<div class="col">
								<ul style="list-style-type:none">
									<%for(int i=0;i<search.getToLoc().size();i++){%><li><input type="radio" name="to" value="<%= search.getToLoc().get(i).toLowerCase()%>"> <%= search.getToLoc().get(i)%></li><%} %>
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
				<!-- End content here! -->
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