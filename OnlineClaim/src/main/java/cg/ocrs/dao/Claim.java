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
		psmt = con.prepareStatement("insert into claim values(?,?,?,?,?,?,?)");
		psmt.setString(1, cl.getClaimId());
		psmt.setString(2, cl.getClaimReason());
		psmt.setString(3, cl.getClaimLocation());
		psmt.setString(4, cl.getClaimState());
		psmt.setString(5, cl.getClaimCity());
		psmt.setInt(6, cl.getClaimZip());
		psmt.setString(7, cl.getClaimType());
		psmt.executeUpdate();
		return cl;
	}

	@Override
	public ClaimAdjuster getClaim(String claimId) throws SQLException {
		psmt = con.prepareStatement("select Location,City from claim where claimId=?");
		psmt.setString(1, claimId);
		rsUser = psmt.executeQuery();
		ClaimAdjuster ca = new ClaimAdjuster();
		while (rsUser.next()) {
			ca.setClaimReason(rsUser.getString("claimReason"));
			ca.setClaimLocation(rsUser.getString("Location"));
			ca.setClaimState(rsUser.getString("State"));
			ca.setClaimCity(rsUser.getString("City"));
			ca.setClaimZip(rsUser.getInt("Zip"));
			ca.setClaimType(rsUser.getString("claimType"));

		}
		return ca;
	}
public int getQuestionName(String questionName) throws SQLException{
int id=0;
psmt=con.prepareStatement("select * from question where questionName=?");
psmt.setString(2, questionName);
rsUser=psmt.executeQuery();
QuestionAndAnswers qa=new QuestionAndAnswers();
while(rsUser.next()) {
	if(qa.getQuestion().equalsIgnoreCase("questionName")) {
		id=qa.getQuestionId();
	}
}
	return id;
	
}
	@Override
	public ArrayList<QuestionAndAnswers> getQuestionAndAnswers(int questionId) throws SQLException {
		psmt = con.prepareStatement("select * from question");
		ArrayList<QuestionAndAnswers> list = new ArrayList<QuestionAndAnswers>();
		rsUser = psmt.executeQuery();
		while (rsUser.next()) {
			QuestionAndAnswers qa = new QuestionAndAnswers();
			qa.setQuestion(rsUser.getString("question"));
			qa.setQuestionId(rsUser.getInt("questionId"));
			PreparedStatement ps = con.prepareStatement("select * from answer where questionid = ?");
			ps.setInt(1, rsUser.getInt("questionId"));
			ResultSet rs = ps.executeQuery();
			ArrayList<String> answers = new ArrayList<String>();
			while (rs.next()) {
				String ans = rs.getString("answer");
				answers.add(ans);
			}
			qa.setAnswers(answers);
			list.add(qa);
		}
		return list;
	}
}
