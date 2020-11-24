package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repositry.Claim;
import repositry.IClaim;

/**
 * Servlet implementation class ClaimViewController
 */
public class ClaimViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClaimViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option=request.getParameter("name");
		String claimId=request.getParameter("Claim-Id:");
			if(option.equals("Enter")) {
				RequestDispatcher rd=request.getRequestDispatcher("Claimview2.jsp");
				rd.forward(request, response);
	}
			
			
			}
	
}
