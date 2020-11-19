package repository;
import com.cg.model.ClaimAdjuster;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

public class Claim implements IClaim{
	Connection con;
	PreparedStatement psmt;
	ResultSet rsUser;
	public Claim() {
		try {
			con=ConnectionUtility.getConnection();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public ClaimAdjuster addUser(ClaimAdjuster user) throws SQLException {
		// TODO Auto-generated method stub
		psmt=con.prepareStatement("insert into UserRole values(?,?,?)");
		psmt.setInt(1, user.getUserId());
		psmt.setInt(2, user.getClaimId());
		psmt.setClaimList(3, user.getClaimList());
		psmt.executeUpdate();
		return user;
	}
	@Override
	public ClaimAdjuster getUser(int userId) throws SQLException {
		// TODO Auto-generated method stub
		psmt=con.prepareStatement("select * from ClaimAdjuster where id=?");
		psmt.setInt(1, userId);
		rsUser=psmt.executeQuery();
		ClaimAdjuster ur=new ClaimAdjuster();
		ur.setUserId(rsUser.getInt("UserId"));
		ur.setClaimId(rsUser.getInt("ClaimId"));
		return ur;
	}
	@Override
	public List<ClaimAdjuster> getAllUsers() throws SQLException {
		// TODO Auto-generated method stub
psmt=con.prepareStatement("select * from UserRole");

		rsUser=psmt.executeQuery();

		List<ClaimAdjuster> users=new ArrayList<>();
		while(rsUser.next()) {
			ClaimAdjuster us=new ClaimAdjuster();
		us.setUserId(rsUser.getInt("UserId"));
		us.setClaimId(rsUser.getInt("ClaimId"));
		users.add(us);
		}
		return users;
	}

}