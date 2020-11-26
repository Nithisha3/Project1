package com.cg.model;

public class Claimhandler {
public Claimhandler(String customerId, int policyNo, int accountNo) {
		super();
		this.customerId = customerId;
		this.policyNo = policyNo;
		this.accountNo = accountNo;
	}
public Claimhandler() {
	super();
	// TODO Auto-generated constructor stub
}
private String customerId;
private int policyNo;
private int accountNo;
public String getCustomerId() {
	return customerId;
}
public void setCustomerId(String customerId) {
	this.customerId = customerId;
}
public int getPolicyNo() {
	return policyNo;
}
public void setPolicyNo(int policyNo) {
	this.policyNo = policyNo;
}
public int getAccountNo() {
	return accountNo;
}
public void setAccountNo(int accountNo) {
	this.accountNo = accountNo;
}

}
