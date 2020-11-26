package repositry;

import com.cg.model.Userrole;
/**
* The claim class implements  that implements Iclaim
*
* @author  :vyshnavi
* @version : 1.8
* @since   : DD-MM-YYYY 
*/
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

public class Login implements ILogin {
	Connection con;
	PreparedStatement psmt;
	ResultSet rsUser;

	public Login() {
		try {
			this.con = Connectionutil.getConnection();
		} catch (Exception e) {
			// System.out.println("1");
		}
	}

	@Override
	public Userrole addUser(Userrole user) throws SQLException {
		// TODO Auto-generated method stub
		try {
			this.con = Connectionutil.getConnection();

		} catch (Exception e) {
			// System.out.println("error");
		}

		psmt = this.con.prepareStatement("insert into UserRole values(?,?,?)");
		psmt.setString(1, user.getUserName());
		psmt.setString(2, user.getPassword());
		psmt.setString(3, user.getRoleCode());
		psmt.executeUpdate();
		return user;
	}

	@Override
	public Userrole getUser(String userName) throws SQLException {
		// TODO Auto-generated method stub
		Userrole ur = new Userrole();
		psmt = con.prepareStatement("select * from Userrole where userName=?");
		psmt.setString(1, userName);
		ResultSet rs = psmt.executeQuery();
		while (rs.next()) {
			ur.setUserName(rs.getString("UserName"));
			ur.setRoleCode(rs.getString("RoleCode"));
		}
		return ur;
	}

	@Override
	public List<Userrole> getAllUsers() throws SQLException {
		// TODO Auto-generated method stub
		psmt = con.prepareStatement("select * from UserRole");

		rsUser = psmt.executeQuery();

		List<Userrole> users = new ArrayList<>();
		while (rsUser.next()) {
			Userrole us = new Userrole();
			us.setUserName(rsUser.getString("UserName"));
			us.setRoleCode(rsUser.getString("RoleCode"));
			users.add(us);
		}
		return users;
	}

}
