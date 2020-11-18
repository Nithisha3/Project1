package repositry;
import com.cg.model.Userrole;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

public class Login implements ILogin{
	Connection con;
	PreparedStatement psmt;
	ResultSet rsUser;
	public Login() {
		try {
			con=Connectionutil.getConnection();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public Userrole addUser(Userrole user) throws SQLException {
		// TODO Auto-generated method stub
		psmt=con.prepareStatement("insert into UserRole values(?,?,?)");
		psmt.setString(1, user.getUserName());
		psmt.setString(2, user.getPassword());
		psmt.setString(3, user.getRoleCode());
		psmt.executeUpdate();
		return user;
	}
	@Override
	public Userrole getUser(String userName) throws SQLException {
		// TODO Auto-generated method stub
		psmt=con.prepareStatement("select * from UserRole where id=?");
		psmt.setString(1, userName);
		rsUser=psmt.executeQuery();
		Userrole ur=new Userrole();
		ur.setUserName(rsUser.getString("UserName"));
		ur.setRoleCode(rsUser.getString("RoleCode"));
		return ur;
	}
	@Override
	public List<Userrole> getAllUsers() throws SQLException {
		// TODO Auto-generated method stub
psmt=con.prepareStatement("select * from UserRole");
		
		rsUser=psmt.executeQuery();
		
		List<Userrole> users=new ArrayList<>();
		while(rsUser.next()) {
		Userrole us=new Userrole();
		us.setUserName(rsUser.getString("UserName"));
		us.setRoleCode(rsUser.getString("RoleCode"));
		users.add(us);
		}
		return users;
	}
	
}
