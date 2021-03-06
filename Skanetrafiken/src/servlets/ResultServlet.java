package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ResultBean;
import cookies.CookieController;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ResultServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text");
		ResultBean result = new ResultBean();
		CookieController cookieController = new CookieController();
		result.setFrom(request.getParameter("from"));
		result.setTo(request.getParameter("to"));
		// Here is where any potential cookies are made
		if (cookieController.cookiesAllowed(request)) {
			cookieController.createCookie(response, result.getTo(), result.getFrom());
		}
		request.setAttribute("resultBean", result);
		RequestDispatcher rd = request.getRequestDispatcher("results.jsp");
		rd.forward(request, response);
	}
}