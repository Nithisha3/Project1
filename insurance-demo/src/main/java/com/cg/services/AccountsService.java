package com.cg.services;

import java.util.ArrayList;

import com.cg.entity.Accounts;

public interface AccountsService {
	Accounts getAccountDetails(String userName);
	
	ArrayList<Accounts> getAccountDetailsforHandler(String userName);

}
