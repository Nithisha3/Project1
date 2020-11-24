package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		HttpSession session = request.getSession();
		ClaimAdjuster ca = (ClaimAdjuster)session.getAttribute("claim");
		IClaim claim = new Claim();
		ArrayList<QuestionAndAnswers> list = (ArrayList<QuestionAndAnswers>)session.getAttribute("QuestionAndAnswers");
		int weightage = 0;
		for(QuestionAndAnswers qa : list) {
			String answer = request.getParameter(qa.getQuestionId()+"");
			if(qa.getAnswer1().equals(answer)) {
				weightage += qa.getWeightage1();
			}
			else if(qa.getAnswer2().equals(answer)) {
				weightage += qa.getWeightage2();
			}
			else if(qa.getAnswer3().equals(answer)) {
				weightage += qa.getWeightage3();
			}
		}
		try {
			
			claim.addClaim(ca);
		}catch(SQLException e) {
			
		}
    }
	
}
