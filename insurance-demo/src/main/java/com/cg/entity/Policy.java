package com.cg.entity;

public class Policy {
	
	private int policyNumber;
	private int policyPremium;
	private int accountNumber;
	
	public Policy() {
		
	}
	
	public Policy(int policyNumber, int policyPremium, int accountNumber) {
		super();
		this.policyNumber = policyNumber;
		this.policyPremium = policyPremium;
		this.accountNumber = accountNumber;
	}

	public int getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}
	public int getPolicyPremium() {
		return policyPremium;
	}
	public void setPolicyPremium(int policyPremium) {
		this.policyPremium = policyPremium;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "Policy [policyNumber=" + policyNumber + ", policyPremium=" + policyPremium + ", accountNumber="
				+ accountNumber + "]";
	}
	
	

}
