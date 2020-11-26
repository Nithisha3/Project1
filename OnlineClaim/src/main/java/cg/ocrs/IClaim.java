package repositry;

import java.sql.SQLException;
import java.util.ArrayList;
import com.cg.model.ClaimAdjuster;
import com.cg.model.QuestionAndAnswers;

public interface IClaim {
		public ClaimAdjuster addClaim(ClaimAdjuster claimList)throws SQLException;
		public ClaimAdjuster getClaim(String claimId)throws SQLException;
		public ArrayList<QuestionAndAnswers> getQuestionAndAnswers()throws SQLException;
		public void saveQuestionAndAnswer(String claimId, String answerNumbers) throws SQLException;
		public String getQuestionAndAnswer(String claimId) throws SQLException;
	}
