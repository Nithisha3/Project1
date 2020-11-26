package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminController
 */
public class AdminController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String option = request.getParameter("name");
		switch (option) {
		case "Profile-create":
			response.sendRedirect("Profilepage.jsp");
			break;
		case "Create-claim":
			response.sendRedirect("Claimcreate.jsp");
			break;
		case "View-claim":
			response.sendRedirect("Claimview.jsp");
			break;
		case "Report":
			response.sendRedirect("Claimview.jsp");
			break;
		case "Logout":
			response.sendRedirect("logoutPage.html");
		default:
			break;

		}
		out.close();
	}

}
