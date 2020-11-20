package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repositry.Claim;
import repositry.IClaim;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter(); 
		String option=request.getParameter("name");
		switch(option) {
		case "Profile-create":
			response.sendRedirect("Profilepage.jsp");
			break;
		case "Create-claim":
			   RequestDispatcher rd1=request.getRequestDispatcher("Claimpage.html");  
		        rd1.include(request,response);  
			break;
		case "View-claim":
			RequestDispatcher rd2=request.getRequestDispatcher("Claimpage.html");  
	        rd2.include(request,response);  
			break;
		case "Report":
			RequestDispatcher rd3=request.getRequestDispatcher("Claimpage.html");  
	        rd3.include(request,response);  
			break;
		case "Logout":
			response.sendRedirect("logoutPage.html");
		default:
			break;
		
		}
		 out.close();
	}

}
