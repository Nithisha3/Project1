package cg.ocrs.service;

import java.sql.SQLException;
import java.util.List;
import cg.ocrs.model.PolicyDetails;

public interface IPolicyDetailsService {
	public List<PolicyDetails> getAllPolicyDetails() throws SQLException;
	public PolicyDetails addPolicyDetails(PolicyDetails policyDetails) throws SQLException;

}
