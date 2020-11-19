package repositry;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.model.ClaimAdjuster;
import com.cg.model.Claimlist;
import com.cg.model.Userrole;

public class Claim implements IClaim{
	Connection con;
	PreparedStatement psmt;
	ResultSet rsUser;
	Claimlist clist=new Claimlist();
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
		psmt=con.prepareStatement("insert into claim values(?,?,?,?,?,?,?)");
		psmt.setInt(1,cl.getClaimId());
		psmt.setString(2,cl.getClaimReason());
		psmt.setString(3, cl.getClaimLocation());
		psmt.setString(4,cl.getClaimState());
		psmt.setString(5, cl.getClaimCity());
		psmt.setInt(6, cl.getClaimZip());
		psmt.setString(7, cl.getClaimType());
        psmt.executeUpdate();
		return cl;
	}
	@Override
	public ClaimAdjuster getClaim(int claimId) throws SQLException{
		psmt=con.prepareStatement("select Location,City from claim where claimId=?");
		psmt.setInt(1, claimId);
		rsUser=psmt.executeQuery();
		ClaimAdjuster ca=new ClaimAdjuster();
		while(rsUser.next()) {
		ca.setClaimReason(rsUser.getString("claimReason"));	
		ca.setClaimLocation(rsUser.getString("Location"));
		ca.setClaimState(rsUser.getString("State"));
		ca.setClaimCity(rsUser.getString("City"));
		ca.setClaimZip(rsUser.getInt("Zip"));
		ca.setClaimType(rsUser.getString("claimType"));
		
	}
			return ca;
	}
}
