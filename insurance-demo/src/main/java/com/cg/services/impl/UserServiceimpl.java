package com.cg.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.dao.UserDao;
import com.cg.entity.UserRole;
import com.cg.services.UserService;

@Component
public class UserServiceimpl implements UserService {
	
	boolean status = false;
	UserDao userDao;
	
	@Autowired
	public UserServiceimpl(UserDao userDao) {
		this.userDao = userDao;
	}
	

	@Override
	public boolean login(UserRole user) {
		status = userDao.validateUser(user);
		return status;
	}


	@Override
	public boolean addUser(UserRole userRole) {
		status = userDao.addUser(userRole);
		return status;
	}

}
