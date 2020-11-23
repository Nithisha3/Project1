package com.cg.entity;

public class ClaimQuestionsAndAnswers {
	private int questionId;
	private int answerId;
	private int claimNumber;
	
	public ClaimQuestionsAndAnswers() {}

	public ClaimQuestionsAndAnswers(int questionId, int answerId, int claimNumber) {
		super();
		this.questionId = questionId;
		this.answerId = answerId;
		this.claimNumber = claimNumber;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public int getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(int claimNumber) {
		this.claimNumber = claimNumber;
	}

	@Override
	public String toString() {
		return "ClaimQuestionsAndAnswers [questionId=" + questionId + ", answerId=" + answerId + ", claimNumber="
				+ claimNumber + "]";
	}
	
	
	
	

}
