package uppgift3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String username=request.getParameter("username");
		String password = request.getParameter("password");
		int tries=Integer.parseInt(request.getParameter("tries"));
		if(!username.equals("admin")||!password.equals("admin")) {
			tries++;
			response.sendRedirect("uppgift3.jsp?tries="+tries);
		}else {
			PrintWriter out = response.getWriter();
			tries=0;
			out.print("<h3>Wellcome Back!</h3>");
			out.print("<form action='uppgift3.jsp?tries=0' method='post'>");
			out.print("<input type='submit' value='Log out'>");
			out.print("</form>");
			out.close();
		}
	}
}