package com.cg.model;

public class Claimlist {
	private int policyNumber;
	private int claimNumber;
	private String claimType;
	public Claimlist(String claimType, int policyNumber, int claimNumber) {
		this.claimNumber=claimNumber;
		this.policyNumber=policyNumber;
		this.claimType=claimType;
	}
	public Claimlist() {
		// TODO Auto-generated constructor stub
		super();
	}
	public int getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}
	public int getClaimNumber() {
		return claimNumber;
	}
	public void setClaimNumber(int claimNumber) {
		this.claimNumber = claimNumber;
	}
	public String getClaimType() {
		return claimType;
	}
	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}
	

}

