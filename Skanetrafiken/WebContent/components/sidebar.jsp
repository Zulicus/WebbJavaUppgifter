<ul
  class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
  id="accordionSidebar"
>
  <!-- Sidebar - Brand -->
  <a
    class="sidebar-brand d-flex align-items-center justify-content-center"
    href="index.jsp"
  >
    <div class="sidebar-brand-text mx-3">Skånetrafiken <sup>2</sup></div>
  </a>

  <!-- Divider -->
  <hr class="sidebar-divider my-0" />

  <!-- Nav Item - Start -->
  <li class="nav-item active">
    <a class="nav-link" href="index.jsp">
      <span>Startsida</span>
    </a>
  </li>
  <!-- Divider -->
  <hr class="sidebar-divider my-0" />

  <!-- Nav Item - Search -->
  <li class="nav-item active">
    <a class="nav-link" href="search.jsp">
      <span>Sök Resa</span>
    </a>
  </li>
  <!-- Divider -->
  <hr class="sidebar-divider my-0" />

  <!-- Nav Item - Previous searches -->
  <li class="nav-item active">
    <a class="nav-link" href="<%=request.getContextPath()%>/CookieServlet">
      <span>Tidigare Sökningar</span>
    </a>
  </li>
  <!-- Divider -->
  <hr class="sidebar-divider my-0" />

  <!-- Nav Item - Tickets -->
  <li class="nav-item active">
    <a class="nav-link" href="tickets.jsp">
      <span>Biljetter</span>
    </a>
  </li>
  <!-- Divider -->
  <hr class="sidebar-divider my-0" />

  <!-- Nav Item - About -->
  <li class="nav-item active">
    <a class="nav-link" href="about.jsp">
      <span>Om Oss</span>
    </a>
  </li>
  <!-- Divider -->
  <hr class="sidebar-divider d-none d-md-block" />

  <!-- Sidebar Toggler (Sidebar) -->
  <div class="text-center d-none d-md-inline">
    <button class="rounded-circle border-0" id="sidebarToggle"></button>
  </div>

  <!-- Sidebar Message -->
  <div class="sidebar-card">
    <p class="text-center mb-2">
      <strong>Viktigt Medeleande Gällande Covid-19!</strong>
    </p>
    <p class="text-center mb-2">
      Idag är det viktigare än någonsin att vi alla gör vårt bästa för att rädda så
      många liv som möjligt!
    </p>
  </div>
</ul>
