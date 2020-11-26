package repositry;

import java.sql.SQLException;
import java.util.List;

import com.cg.model.Userrole;

public interface ILogin {
	public Userrole addUser(Userrole user)throws SQLException;
	public Userrole getUser(String userName)throws SQLException;
	public List<Userrole> getAllUsers()throws SQLException;
	

}
