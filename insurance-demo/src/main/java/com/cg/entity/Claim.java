package com.cg.entity;

public class Claim {
	private Integer claimNumber;
	private String claimReason;
	private String accidentLocationStreet;
	private String accidentCity;
	private String accidentState;
	private Integer accidentZip;
	private String claimType;
	private Integer policyNumber;
	
	
	public Claim() {
		
	}
	public Claim(Integer claimNumber, String claimReason, String accidentLocationStreet, String accidentCity,
			String accidentState, Integer accidentZip, String claimType, Integer policyNumber) {
		super();
		this.claimNumber = claimNumber;
		this.claimReason = claimReason;
		this.accidentLocationStreet = accidentLocationStreet;
		this.accidentCity = accidentCity;
		this.accidentState = accidentState;
		this.accidentZip = accidentZip;
		this.claimType = claimType;
		this.policyNumber = policyNumber;
	}
	
	
	public Integer getClaimNumber() {
		return claimNumber;
	}
	public void setClaimNumber(Integer claimNumber) {
		this.claimNumber = claimNumber;
	}
	public String getClaimReason() {
		return claimReason;
	}
	public void setClaimReason(String claimReason) {
		this.claimReason = claimReason;
	}
	public String getaccidentLocationStreet() {
		return accidentLocationStreet;
	}
	public void setaccidentLocationStreet(String accidentLocationStreet) {
		this.accidentLocationStreet = accidentLocationStreet;
	}
	public String getAccidentCity() {
		return accidentCity;
	}
	public void setAccidentCity(String accidentCity) {
		this.accidentCity = accidentCity;
	}
	public String getAccidentState() {
		return accidentState;
	}
	public void setAccidentState(String accidentState) {
		this.accidentState = accidentState;
	}
	public Integer getAccidentZip() {
		return accidentZip;
	}
	public void setAccidentZip(Integer accidentZip) {
		this.accidentZip = accidentZip;
	}
	public String getClaimType() {
		return claimType;
	}
	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}
	public Integer getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(Integer policyNumber) {
		this.policyNumber = policyNumber;
	}
	
	@Override
	public String toString() {
		return "Claim [claimNumber=" + claimNumber + ", claimReason=" + claimReason + ", accidentLocationStreet="
				+ accidentLocationStreet + ", accidentCity=" + accidentCity + ", accidentState=" + accidentState
				+ ", accidentZip=" + accidentZip + ", claimType=" + claimType + ", policyNumber=" + policyNumber + "]";
	}
	
	

}
