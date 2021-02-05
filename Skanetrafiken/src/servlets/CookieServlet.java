package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cookies.CookieController;
import cookies.CookieBean;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CookieServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text");
		CookieController cookieController = new CookieController();
		// Checks so that Cookies are allowed
		if (cookieController.cookiesAllowed(request)) {
			try {
				ArrayList<String> toFromPoints = cookieController.getCookies(request);
				ArrayList<String> toPoints = new ArrayList<String>();
				ArrayList<String> fromPoints = new ArrayList<String>();
				// Cuts the destination and the initial travel points from each other
				for (int i = 0; i < toFromPoints.size(); i++) {
					String[] splitPoints = toFromPoints.get(i).split("!");
					toPoints.add(splitPoints[0]);
					fromPoints.add(splitPoints[1]);
				}
				CookieBean bean = new CookieBean();
				bean.setTo_Cookies(toPoints);
				bean.setFrom_Cookies(fromPoints);
				request.setAttribute("cookieBean", bean);
				RequestDispatcher rd = request.getRequestDispatcher("oldSearch.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("failedOldSearch.jsp");
			rd.forward(request, response);
		}
	}
}