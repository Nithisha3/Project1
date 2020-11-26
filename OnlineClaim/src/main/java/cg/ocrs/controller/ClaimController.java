package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.model.ClaimAdjuster;
import com.cg.model.QuestionAndAnswers;

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
		try {
			response.setContentType("text/html");
			HttpSession session = request.getSession();
			PrintWriter out = response.getWriter();
			String claimid = request.getParameter("claimId");
			String claimReason = request.getParameter("claimReason");
			String Location = request.getParameter("Location");
			String City = request.getParameter("City");
			String State = request.getParameter("State");
			String code = request.getParameter("Zip");
			int Zip = Integer.parseInt(code);
			String claimType = request.getParameter("claimType");
			ClaimAdjuster cl = new ClaimAdjuster(claimid, claimReason, Location, City, State, Zip, claimType);
			session.setAttribute("claim", cl);
			IClaim claim = new Claim();
			/*
			 * if (claim.getClaim(cl.getClaimId()) != null) { throw new
			 * ServletException("Claim Already Exists"); }
			 */
			List<QuestionAndAnswers> qa;
			qa = claim.getQuestionAndAnswers();

			session.setAttribute("QuestionAndAnswers", qa);
			RequestDispatcher rd = request.getRequestDispatcher("ClaimNumber.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * protected void viewStudent(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException, SQLException { int questionId
	 * = Integer.parseInt(request.getParameter("questionId")); IClaim claim = new
	 * Claim(); claim.getQuestionAndAnswers(questionId); HttpSession ssn =
	 * request.getSession(); ssn.setAttribute("claim", claim);
	 * response.sendRedirect("ClaimNumber.jsp"); }
	 */

}
