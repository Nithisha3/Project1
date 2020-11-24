package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.model.ClaimAdjuster;
import repositry.Claim;
import repositry.IClaim;

/**
 * Servlet implementation class ClaimController
 */
public class ClaimController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClaimController() {
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
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {

			String claimid = request.getParameter("claimId");
			String claimReason = request.getParameter("claimReason");
			String Location = request.getParameter("Location");
			String City = request.getParameter("City");
			String State = request.getParameter("State");
			String code = request.getParameter("Zip");
			int Zip = Integer.parseInt(code);
			String claimType = request.getParameter("claimType");
			ClaimAdjuster cl = new ClaimAdjuster(claimid, claimReason, Location, City, State, Zip, claimType);
			String option = request.getParameter("name");
			if (option.equals("Next")) {
				response.sendRedirect("ClaimNumber.jsp");
			}
		}
			 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*protected void viewStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int questionId = Integer.parseInt(request.getParameter("questionId"));
		IClaim claim = new Claim();
		claim.getQuestionAndAnswers(questionId);
		HttpSession ssn = request.getSession();
		ssn.setAttribute("claim", claim);
		response.sendRedirect("ClaimNumber.jsp");
	}*/

}
