package repositry;

import java.sql.SQLException;


import com.cg.model.ClaimAdjuster;

public interface IClaim {
		public ClaimAdjuster addClaim(ClaimAdjuster claimList)throws SQLException;
		public ClaimAdjuster getClaim(int claimId)throws SQLException;
		

	}
