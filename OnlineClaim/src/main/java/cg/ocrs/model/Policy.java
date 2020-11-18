package cg.ocrs.model;

public class Policy {
	private int policyNumber;
	private float policyPremium;
	private int accountNumber;
	
	
	public int getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}
	public float getPolicyPremium() {
		return policyPremium;
	}
	public void setPolicyPremium(float policyPremium) {
		this.policyPremium = policyPremium;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Policy() {
		// TODO Auto-generated constructor stub
	}
	public Policy(int policyNumber, float policyPremium, int accountNumber) {
		super();
		this.policyNumber = policyNumber;
		this.policyPremium = policyPremium;
		this.accountNumber = accountNumber;
	}
	@Override
	public String toString() {
		return "Policy [policyNumber=" + policyNumber + ", policyPremium=" + policyPremium + ", accountNumber="
				+ accountNumber + "]";
	}

}
