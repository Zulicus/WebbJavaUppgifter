package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cookies.CookieController;
import cookies.CookieBean;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CookieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text");
		CookieController cookieController = new CookieController();
		if (cookieController.cookiesAllowed(request)) {
			try {
				ArrayList<String> toFromPoints = cookieController.getCookies(request),
						toPoints = new ArrayList<String>(), fromPoints = new ArrayList<String>();
				for (int i = 0; i < toFromPoints.size(); i++) {
					String[] splitPoints = toFromPoints.get(i).split("!");
					toPoints.add(splitPoints[0]);
					fromPoints.add(splitPoints[1]);
				}
				toPoints.forEach(e->System.out.println(e));
				fromPoints.forEach(e->System.out.println(e));
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
