package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This servlet checks the value of session attribute and forwards to desired
 * page if value is not null otherwise redirects to LogIn servlet on recieving
 * get request.
 * 
 * 
 * 
 */
@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Welcome() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect("/StudentRegistrationSystem/LogIn");
		}

		else {
			String user = (String) session.getAttribute("USERNAME");
			String dsg = (String) session.getAttribute("DESG");
			
			if (dsg.equals("Councilor"))
			{
				RequestDispatcher rd = request
						.getRequestDispatcher("/Councilor/Home.jsp");
				request.setAttribute("USERNAME", user);
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request
						.getRequestDispatcher("/Registrar/Home.jsp");
				request.setAttribute("USERNAME", user);
				rd.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
