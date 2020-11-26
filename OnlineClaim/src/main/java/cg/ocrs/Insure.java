package repositry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.model.Claimlist;
import com.cg.model.Insured;
import com.cg.model.Userrole;

public class Insure implements InterfaceInsure {
	Connection con;
	PreparedStatement psmt;
	ResultSet rsUser;
	Claimlist clist = new Claimlist();

	public Insure() {
		try {
			con = Connectionutil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Integer> getAllPolicy() throws SQLException {
		psmt = con.prepareStatement("select * from Account");

		rsUser = psmt.executeQuery();

		List<Integer> in = new ArrayList<>();
		while (rsUser.next()) {
			in.add(rsUser.getInt("policyNumber"));
		}
		
		return in;
	}
	
	
}

