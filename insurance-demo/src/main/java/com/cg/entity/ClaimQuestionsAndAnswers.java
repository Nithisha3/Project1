package com.cg.entity;

public class ClaimQuestionsAndAnswers {
	private int questionId;
	private int answerId;
	private int claimId;
	private int weightage;
	
	public ClaimQuestionsAndAnswers() {}

	public ClaimQuestionsAndAnswers(int questionId, int answerId, int claimId, int weightage) {
		super();
		this.questionId = questionId;
		this.answerId = answerId;
		this.claimId = claimId;
		this.weightage = weightage;
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

	public int getClaimId() {
		return claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}
	
	public int getWeightage() {
		return weightage;
	}

	public void setWeightage(int weightage) {
		this.weightage = weightage;
	}

	@Override
	public String toString() {
		return "ClaimQuestionsAndAnswers [questionId=" + questionId + ", answerId=" + answerId + ", claimId="
				+ claimId + ", weightage=" + weightage + "]";
	}


	
	
	

}
