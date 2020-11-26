package repositry;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.model.Insured;

public interface InterfaceInsure {
	public List<Integer> getAllPolicy() throws SQLException;
}
