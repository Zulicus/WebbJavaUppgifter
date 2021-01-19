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
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LoginBean logBean = new LoginBean();
		
		Cookie[] cookie = request.getCookies();
		if (cookie != null) {
			for (int i = 0; i < cookie.length; i++) {
				if (cookie[i].getName().equals("SessionValidation")) {
					User user = new User();
					user = user.getUser(cookie[i].getValue().toLowerCase());
					logBean.setUser(user);
					request.setAttribute("LoginBean", logBean);
					login(request, response, cookie[i].getValue());
				}
			}
		}

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		logBean.setUserName(username);
		logBean.setPassword(password);

		request.setAttribute("LoginBean", logBean);
		try {
			if (logBean.validate()) {
				login(request, response, logBean.getUserName());
			}
		} catch (Exception e) {
			System.out.println(e);
			RequestDispatcher rd = request.getRequestDispatcher("login-failed.jsp");
			rd.forward(request, response);
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response, String userName)
			throws ServletException, IOException {
		Cookie cookie = new Cookie("SessionValidation", userName);
		cookie.setMaxAge(20);
		response.addCookie(cookie);
		RequestDispatcher rd = request.getRequestDispatcher("logged-in.jsp");
		rd.forward(request, response);

	}

}
