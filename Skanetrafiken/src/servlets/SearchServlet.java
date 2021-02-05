package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.SearchBean;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchServlet() {
		super();
	}

// Here is where the initial search is processed and sent to the Search Results page
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text");
		SearchBean search = new SearchBean();
		search.setFrom(request.getParameter("from"));
		search.setTo(request.getParameter("to"));
		request.setAttribute("searchBean", search);
		RequestDispatcher rd = request.getRequestDispatcher("searchResults.jsp");
		rd.forward(request, response);
	}
}