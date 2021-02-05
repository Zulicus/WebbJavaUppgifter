<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <jsp:include page="components/headinfo.jsp" />
    <title>Skånetrafiken - Sök resa</title>
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
          <form
            action="<%=request.getContextPath()%>/SearchServlet"
            method="post"
          >
            <div class="container">
              <div class="row">
                <div class="col">
                  <input
                    type="text"
                    name="from"
                    required
                    pattern="^[a-zA-Zåäö\s]*$"
                    placeholder="From..."
                  />
                </div>
                <div class="col">
                  <input
                    type="text"
                    name="to"
                    required
                    pattern="^[a-zA-Zåäö\s]*$"
                    placeholder="To..."
                  />
                </div>
                <div class="col">
                  <input type="submit" value="Sök resa" />
                </div>
              </div>
            </div>
          </form>
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