package repositry;

import java.sql.SQLException;


import com.cg.model.ClaimAdjuster;

public interface IClaim {
		public ClaimAdjuster addClaim(ClaimAdjuster claimList)throws SQLException;
		public ClaimAdjuster getClaim(String claimId)throws SQLException;
		public ArrayList<QuestionAndAnswers> getQuestionAndAnswers(int questionId)throws SQLException;
		public int getQuestionName(String questionName) throws SQLException;

	}
