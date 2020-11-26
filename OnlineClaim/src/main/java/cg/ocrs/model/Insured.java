package com.cg.model;

public class Insured {
	public Insured(int policyNo, int accountNo, int premiumAmount) {
		super();
		this.policyNo = policyNo;
		this.accountNo = accountNo;
		this.premiumAmount = premiumAmount;
	}
	public Insured() {
		// TODO Auto-generated constructor stub
		super();
	}
	private int policyNo;
	private int accountNo;
	private int premiumAmount;
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
	public int getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(int premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

}
