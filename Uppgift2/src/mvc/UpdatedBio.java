package mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import users.User;

/**
 * Servlet implementation class UpdatedBio
 */
@WebServlet("/UpdatedBio")
public class UpdatedBio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatedBio() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String bio = request.getParameter("bio");
		LoginBean bean = new LoginBean();
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("SessionValidation")) {
					User user = new User();
					user = user.getUser(cookies[i].getValue().toLowerCase());
					bean.setUser(user);
					request.setAttribute("LoginBean", bean);
					bean.getUser().setBio(bio);
					Cookie cookie = new Cookie("SessionValidation", cookies[i].getValue());
					cookie.setMaxAge(20);
					response.addCookie(cookie);
					RequestDispatcher rd = request.getRequestDispatcher("logged-in.jsp");
					rd.forward(request, response);
				}
			}
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
