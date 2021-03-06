package com.cg.model;

	public class ClaimAdjuster {
		
		@Override
		public String toString() {
			return "ClaimAdjuster [userId=" + userId + ", claimId=" + claimId + ", claimReason=" + claimReason
					+ ", claimLocation=" + claimLocation + ", claimCity=" + claimCity + ", claimState=" + claimState
					+ ", claimZip=" + claimZip + ", claimType=" + claimType + ", claimNumber=" + claimNumber + "]";
		}
		private int userId;
		private String claimId;
		private String claimReason;
		private String claimLocation;
		private String claimCity;
		private String claimState;
		private int claimZip;
		private String claimType;
		private int claimNumber;
		
		public int getClaimNumber() {
			return claimNumber;
		}
		public void setClaimNumber(int claimNumber) {
			this.claimNumber = claimNumber;
		}
		public ClaimAdjuster() {
			super();
		}
		public ClaimAdjuster(String claimId, String claimReason, String claimLocation, String claimState, String claimCity,int claimZip,String claimType) {
			super();
			this.claimId=claimId;
			this.claimReason=claimReason;
			this.claimLocation=claimLocation;
			this.claimState=claimState;
			this.claimCity=claimCity;
			this.claimZip=claimZip;
			this.claimType=claimType;
			
		}
	
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public String getClaimId() {
			return claimId;
		}
		public void setClaimId(String claimId) {
			this.claimId = claimId;
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
		public String getClaimType() {
			return claimType;
		}
		public void setClaimType(String claimType) {
			this.claimType = claimType;
		}

		}


