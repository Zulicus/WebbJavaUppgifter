package uppgift2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class List
 */
@WebServlet("/List")
public class List extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public List() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String amount= request.getParameter("amount");
		String subject=request.getParameter("subject");
		int length=0;
		try {
		length=Integer.parseInt(amount);
		}catch(Exception e) {
			System.out.println(e);
		}
		out.print("<h1>Here's your list of "+subject+"s!</h1>");
		out.print("<ol class='list'>");
		switch(subject) {
		case "cat":
			out.print("<script>function getCat(){\r\n"
					+ " fetch(\"https://aws.random.cat/meow\")\r\n"
					+ " 	.then((response) => response.json())\r\n"
					+ " 		.then((data) => {\r\n"
					+ " 			let cat = data.file;\r\n"
					+ " 			const screen = document.querySelector('.list');\r\n"
					+ " 			const image = document.createElement('img');\r\n"
					+ " 			const listEL = document.createElement('li');\r\n"
					+ "				image.alt = 'Image was not found or could not be displayed';\r\n"
					+ " 			image.src = cat;\r\n"
					+ " 			image.style.cssText='width:400px;height:400px;';\r\n"
					+ " 			listEL.appendChild(image);\r\n"
					+ " 			screen.appendChild(listEL);\r\n"
					+ "})};\r\n"
					+ "</script>");
			out.print("<script>for(let i=0;i<"+length+";i++){getCat();}</script>");
			break;
		case "dog":
			out.print("<script>function getDog(){\r\n"
					+ "	fetch(\"https://random.dog/woof.json\")\r\n"
					+ "		.then((response) => response.json())\r\n"
					+ "			.then((data) => {\r\n"
					+ "				let dog = data.url;\r\n"
					+ "				const screen = document.querySelector(\".list\");\r\n"
					+ "				const image = document.createElement(\"img\");\r\n"
					+ "				const listEL = document.createElement(\"li\");\r\n"
					+ "				image.style.cssText='width:400px;height:400px;';\r\n"
					+ "				image.alt = 'Image was not found or could not be displayed';\r\n"
					+ "				image.src = dog;\r\n"
					+ "				listEL.appendChild(image);\r\n"
					+ "				screen.appendChild(listEL);\r\n"
					+ "})};\r\n"
					+ "</script>");
			out.print("<script>for(let i=0;i<"+length+";i++){getDog();}</script>");
			break;
		default: 
			break;
		}	
		out.print("</ol>");
		out.close(); 
	}
}