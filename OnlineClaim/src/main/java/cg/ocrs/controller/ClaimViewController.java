package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.model.ClaimAdjuster;
import com.cg.model.QuestionAndAnswers;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String option = request.getParameter("name");
		IClaim claim = new Claim();
		String claimId = request.getParameter("claimId");
		try {
			RequestDispatcher rd = request.getRequestDispatcher("Claimview2.jsp");
			ClaimAdjuster cl = claim.getClaim(claimId);
			request.setAttribute("claimDetails", cl);
			if (option.equals("GenerateReport")) {
				rd = request.getRequestDispatcher("Report.jsp");
				ArrayList<QuestionAndAnswers> qa = claim.getQuestionAndAnswers();
				String answer = claim.getQuestionAndAnswer(claimId);
				String[] x = answer.split(",");
				ArrayList<String> questions = new ArrayList<>();
				ArrayList<String> answers = new ArrayList<>();
				for (int i = 0; i < qa.size(); i++) {
					questions.add(qa.get(i).getQuestion());
					if (x[i].equals("1")) {
						answers.add(qa.get(i).getAnswer1());
					} else if (x[i].equals("2")) {
						answers.add(qa.get(i).getAnswer2());
					} else if (x[i].equals("3")) {
						answers.add(qa.get(i).getAnswer3());
					}
				}
				request.setAttribute("answers", answers);
				request.setAttribute("questions", questions);
			}
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
