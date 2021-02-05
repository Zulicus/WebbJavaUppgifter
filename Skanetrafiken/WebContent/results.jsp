<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%@page import="beans.ResultBean"%>
<!DOCTYPE html>
<html lang="en">
<%ResultBean result = (ResultBean) request.getAttribute("resultBean");%>
<head>
<jsp:include page="components/headinfo.jsp" />
    <title>Skånetrafiken - Startsida</title>
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
					<div class="row">
						<div class="col">
							<p>Söker bästa resa från <%= result.getFrom().replaceAll("Ã¶", "ö").replaceAll("Ã¤", "ä").replaceAll("Ã¥", "å") %> till <%= result.getTo().replaceAll("Ã¶", "ö").replaceAll("Ã¤", "ä").replaceAll("Ã¥", "å") %></p>
						</div>
					</div>
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