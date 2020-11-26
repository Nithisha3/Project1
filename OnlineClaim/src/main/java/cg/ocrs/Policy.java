package repositry;
/**
* The policy class implements  that implements IPolicy
*
* @author  :spandana,nithisha
* @version : 1.8
* @since   : DD-MM-YYYY 
*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.cg.model.ClaimAdjuster;
import com.cg.model.Claimhandler;
import com.cg.model.Claimlist;

public class Policy implements IPolicy{
	Connection con;
	PreparedStatement psmt;
	ResultSet rsUser;
	Claimlist clist = new Claimlist();

	public Policy() {
		try {
			con = Connectionutil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<String> getCustomer(String claimhandler) throws SQLException {
		psmt = con.prepareStatement("select * from Account where claimhandler=?");
		psmt.setString(1, claimhandler);
		rsUser = psmt.executeQuery();
		ArrayList<String> customers = new ArrayList<>();
		while (rsUser.next()) {
			customers.add(rsUser.getString("custId"));
		}
		return customers;
	}
}

	
