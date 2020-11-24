package com.cg.services;

import com.cg.entity.UserRole;

public interface UserService {
	
	boolean login(UserRole user);
	
	boolean addUser(UserRole userRole);

}
