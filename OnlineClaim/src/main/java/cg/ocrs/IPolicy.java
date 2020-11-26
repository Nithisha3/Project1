package repositry;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.model.Claimhandler;

public interface IPolicy {
	public ArrayList<String> getCustomer(String claimhandler) throws SQLException;

}
