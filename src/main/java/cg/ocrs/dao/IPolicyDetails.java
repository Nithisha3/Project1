package cg.ocrs.dao;

import java.sql.SQLException;

import antlr.collections.List;
import cg.ocrs.model.PolicyDetails;

public interface IPolicyDetails {
		public List getAllPolicyDetails() throws SQLException;
		public PolicyDetails addPolicyDetails(PolicyDetails policyDetails) throws SQLException;

	}



