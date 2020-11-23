package com.cg.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.dao.AccountsDao;
import com.cg.entity.Accounts;
import com.cg.services.AccountsService;

@Component
public class AccountsServiceImpl implements AccountsService {
	AccountsDao accountsDao;
	
	@Autowired
	public AccountsServiceImpl(AccountsDao accountsDao) {
		this.accountsDao = accountsDao;
	}

	@Override
	public Accounts getAccountDetails(String userName) {
		Accounts accounts = accountsDao.getAccountDetails(userName);
		return accounts;
	}

	@Override
	public ArrayList<Accounts> getAccountDetailsforHandler(String userName) {
		ArrayList<Accounts> accountsArrayList = accountsDao.getAccountDetailsforHandler(userName);
		return accountsArrayList;
	}

}
