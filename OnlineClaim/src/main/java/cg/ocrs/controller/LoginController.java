package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.model.ClaimAdjuster;
import com.cg.model.Userrole;

import repositry.ILogin;
import repositry.Login;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String option=request.getParameter("name");
	ILogin login=new Login();
	String uri = request.getRequestURI();
	HttpSession session = request.getSession();
	String userName = request.getParameter("Username");
	RequestDispatcher rd = request.getRequestDispatcher("Login2.jsp");
	try {
		Userrole ur = login.getUser(userName);
		session.setAttribute("Profile", ur);
		if(ur.getUserName() == null || ur.getPassword() == null) {
			throw new SQLException("User Doesn't exist");
		}
		request.setAttribute("success", true);
	}
	catch (SQLException e) {
		request.setAttribute("success", false);
	}
	rd.forward(request, response);
}
}
