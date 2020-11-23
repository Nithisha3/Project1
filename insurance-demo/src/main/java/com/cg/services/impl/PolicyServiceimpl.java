package com.cg.services.impl;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.cg.dao.PolicyDao;
import com.cg.entity.Policy;
import com.cg.services.PolicyService;

@Component
public class PolicyServiceimpl implements PolicyService {
	PolicyDao policyDao;
	
	
	@Autowired
	public PolicyServiceimpl(PolicyDao policyDao) {
		this.policyDao = policyDao;
	}
	/*
	 * @Override public List<Policy> getPolicyDetails(int accountNumber) {
	 * List<Policy> policyList = policyDao.getPolicyDetails(accountNumber); return
	 * policyList; }
	 */

	@Override
	public ArrayList<Policy> getPolicyDetails(int accountNumber) {
		ArrayList<Policy> policyList = policyDao.getPolicyDetails(accountNumber);
		return policyList;
	}

}
