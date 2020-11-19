package com.cg.model;

	public class ClaimAdjuster {
		private int userId;
		private int claimId;
		private String claimReason;
		private String claimLocation;
		private String claimCity;
		private String claimState;
		private int claimZip;
		private Claimlist claimList;
		
	
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public int getClaimId() {
			return claimId;
		}
		public void setClaimId(int claimId) {
			this.claimId = claimId;
		}
		public Claimlist getClaimList() {
			return claimList;
		}
		public void setClaimList(Claimlist claimList) {
			this.claimList = claimList;
		}
		public String getClaimReason() {
			return claimReason;
		}
		public void setClaimReason(String claimReason) {
			this.claimReason = claimReason;
		}
		public String getClaimLocation() {
			return claimLocation;
		}
		public void setClaimLocation(String claimLocation) {
			this.claimLocation = claimLocation;
		}
		public String getClaimCity() {
			return claimCity;
		}
		public void setClaimCity(String claimCity) {
			this.claimCity = claimCity;
		}
		public String getClaimState() {
			return claimState;
		}
		public void setClaimState(String claimState) {
			this.claimState = claimState;
		}
		public void setClaimZip(int claimZip) {
			this.claimZip=claimZip;
		}
		public int getClaimZip() {
			return claimZip;
		}

		}


