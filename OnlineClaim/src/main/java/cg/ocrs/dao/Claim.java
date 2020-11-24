package repositry;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.model.ClaimAdjuster;
import com.cg.model.Claimlist;
import com.cg.model.QuestionAndAnswers;
import com.cg.model.Userrole;

public class Claim implements IClaim {
	Connection con;
	PreparedStatement psmt;
	ResultSet rsUser;
	Claimlist clist = new Claimlist();

	public Claim() {
		try {
			con = Connectionutil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ClaimAdjuster addClaim(ClaimAdjuster cl) throws SQLException {
		// TODO Auto-generated method stub
		psmt = con.prepareStatement("insert into claim values(?,?,?,?,?,?,?,?)");
		psmt.setString(1, cl.getClaimId());
		psmt.setString(2, cl.getClaimReason());
		psmt.setString(3, cl.getClaimLocation());
		psmt.setString(4, cl.getClaimState());
		psmt.setString(5, cl.getClaimCity());
		psmt.setInt(6, cl.getClaimZip());
		psmt.setString(7, cl.getClaimType());
		psmt.setInt(8, cl.getClaimNumber());
		psmt.executeUpdate();
		return cl;
	}

	@Override
	public ClaimAdjuster getClaim(String claimId) throws SQLException {
		psmt = con.prepareStatement("select * from claim where claimId=?");
		psmt.setString(1, claimId);
		rsUser = psmt.executeQuery();
		ClaimAdjuster ca = new ClaimAdjuster();
		while (rsUser.next()) {
			System.out.println("CLAIMID -----------"+rsUser.getString("claimid"));
			ca.setClaimId(rsUser.getString("claimid"));
			ca.setClaimReason(rsUser.getString("claimReason"));
			ca.setClaimLocation(rsUser.getString("Location"));
			ca.setClaimState(rsUser.getString("State"));
			ca.setClaimCity(rsUser.getString("City"));
			ca.setClaimZip(rsUser.getInt("Zip"));
			ca.setClaimType(rsUser.getString("claimType"));

		}
		return ca;
	}
	
	@Override
	public ArrayList<QuestionAndAnswers> getQuestionAndAnswers() throws SQLException {
		psmt = con.prepareStatement("select * from questionandanswers");
		ArrayList<QuestionAndAnswers> list = new ArrayList<QuestionAndAnswers>();
		rsUser = psmt.executeQuery();
		while (rsUser.next()) {
			QuestionAndAnswers qa = new QuestionAndAnswers();
			qa.setQuestionId(rsUser.getInt("questionId"));
			qa.setQuestion(rsUser.getString("question"));
			qa.setAnswer1(rsUser.getString("answer1"));
			qa.setAnswer2(rsUser.getString("answer2"));
			qa.setAnswer3(rsUser.getString("answer3"));
			qa.setWeightage1(rsUser.getInt("weightage1"));
			qa.setWeightage2(rsUser.getInt("weightage2"));
			qa.setWeightage3(rsUser.getInt("weightage3"));
			list.add(qa);
		}
		return list;
	}
	
	
}
