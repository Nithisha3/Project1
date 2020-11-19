package repositry;

import java.sql.*;
import java.sql.SQLException;


import com.cg.model.ClaimAdjuster;

public class Claim implements IClaim{
	Connection con;
	PreparedStatement psmt;
	ResultSet rsUser;
	public Claim() {
		try {
			con=Connectionutil.getConnection();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public ClaimAdjuster addClaim(ClaimAdjuster cl) throws SQLException {
		// TODO Auto-generated method stub
		psmt=con.prepareStatement("insert into Claim values(?,?,?,?,?,?,?,?,?)");
		psmt.setInt(1,cl.getClaimId());
		psmt.setString(2,cl.getClaimReason());
		psmt.setString(3, cl.getClaimLocation());
		psmt.setString(4,cl.getClaimState());
		psmt.setString(5, cl.getClaimCity());
		psmt.setInt(6, cl.getClaimZip());
		psmt.setString(7,cl.getClaimList().getClaimType());
		psmt.setInt(8,cl.getClaimList().getPolicyNumber());
		psmt.setInt(9, cl.getClaimList().getClaimNumber());
		return cl;
	}
	@Override
	public ClaimAdjuster getClaim(int claimId) throws SQLException {
		psmt=con.prepareStatement("select * from claim where id=?");
		psmt.setInt(1, claimId);
		rsUser=psmt.executeQuery();
		ClaimAdjuster ca=new ClaimAdjuster();
		ca.setClaimId(rsUser.getInt("claimId"));
		ca.setClaimReason(rsUser.getString("claimReason"));
		ca.setClaimLocation(rsUser.getString("Location"));
		ca.setClaimCity(rsUser.getString("City"));
		ca.setClaimState(rsUser.getString("State"));
		ca.setClaimZip(rsUser.getInt("Zip"));
		// TODO Auto-generated method stub
		return ca;
	}
}
