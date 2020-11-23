package com.cg.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.cg.entity.Policy;

public interface PolicyService {
	
	ArrayList<Policy> getPolicyDetails(int accountNumber);


}
