<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
        <div id="content">
          <jsp:include page="components/topbar.jsp" />
          <!-- Add content here! -->
          <img
            src="components/images/background.png"
            alt="content.png"
            style="max-width: 100%"
          />
        </div>
        <!-- End of Main Content -->
        <jsp:include page="components/footer.jsp" />
      </div>
      <!-- End of Content Wrapper -->
    </div>
    <!-- End of Page Wrapper -->
    <jsp:include page="components/bootstrap.jsp" />
  </body>
</html>