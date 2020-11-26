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

import repositry.Claim;
import repositry.IClaim;
import repositry.ILogin;
import repositry.IPolicy;
import repositry.Insure;
import repositry.InterfaceInsure;
import repositry.Login;
import repositry.Policy;

/**
 * Servlet implementation class MainController
 */
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub
	 * response.getWriter().append("Served at: ").append(request.getContextPath());
	 * }
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		HttpSession session = request.getSession();
		Userrole ur = (Userrole) session.getAttribute("Profile");
		String roleCode = ur.getRoleCode();
		String userName=ur.getUserName();
		if(userName!=null) {
			session.setAttribute("loggedIn", userName);
			session.setAttribute("roleCode", roleCode);	
		}
		if(roleCode.equals("Insured")) {
			InterfaceInsure in = new Insure();
			try {
				RequestDispatcher rd = request.getRequestDispatcher("Insured.jsp");
				request.setAttribute("policies", in.getAllPolicy());
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(roleCode.equals("Claim Handler")) {
			IPolicy policy = new Policy();
			try {
				RequestDispatcher rd = request.getRequestDispatcher("ClaimHandler.jsp");
				request.setAttribute("customers", policy.getCustomer(ur.getUserName()));
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(roleCode.equals("Claim Adjuster")) {
			response.sendRedirect("Admin.jsp");
		}
		
	}

}
