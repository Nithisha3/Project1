package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.model.Userrole;

import repositry.Connectionutil;
import repositry.ILogin;
import repositry.Login;

/**
 * Servlet implementation class UserController
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
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
		ILogin login = new Login();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {

			String usname = request.getParameter("UserName");
			String password = request.getParameter("Password");
			String role = request.getParameter("Role");
			Userrole us = new Userrole(usname, password, role);
			String option = request.getParameter("name");
			if (option.equals("Sign-up")) {
				response.sendRedirect("success.jsp");
			} else if (option.equals("Logout")) {
				response.sendRedirect("Logout.html");
			}
			login.addUser(us);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
