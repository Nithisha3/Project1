package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.model.QuestionAndAnswers;

import repositry.Claim;
import repositry.IClaim;

/**
 * Servlet implementation class SubmitController
 */
public class SubmitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
IClaim cl;
	
	@Override
	public void init() throws ServletException {
		
		try {
			cl=new Claim();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public SubmitController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		if(uri.contains("/view-student")) {
			try {
				viewQuestion(request, response);
			} catch (SQLException e) {
				response.sendError(500);
			}
			
		}
    }
    protected void viewQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String questionName=request.getParameter("value");
		int questionId=cl.getQuestionName(questionName);
		ArrayList<QuestionAndAnswers> qa=cl.getQuestionAndAnswers(questionId);
		HttpSession ssn=request.getSession();
		ssn.setAttribute("qa", qa);
		response.sendRedirect("ClaimNumber.jsp");	
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String option=request.getParameter("name");
		if(option.equals("Submit")) {
			response.sendRedirect("Submit.jsp");
		}

	}

}
