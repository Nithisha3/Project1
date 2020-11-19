package repository;

import java.sql.SQLException;
import java.util.List;

import com.cg.model.ClaimAdjuster;

public interface IClaim {
	public ClaimAdjuster addUser(ClaimAdjuster user)throws SQLException;
	public ClaimAdjuster getUser(int userId)throws SQLException;
	public List<ClaimAdjuster> getAllUsers()throws SQLException;


}
