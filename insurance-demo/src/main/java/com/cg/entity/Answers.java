package com.cg.entity;

public class Answers {
	
	private int answerId;
	private String answer;
	private int weightage;
	private int questionId;
	
	public Answers() {}

	public Answers(int answerId, String answer, int weightage, int questionId) {
		super();
		this.answerId = answerId;
		this.answer = answer;
		this.weightage = weightage;
		this.questionId = questionId;
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getWeightage() {
		return weightage;
	}

	public void setWeightage(int weightage) {
		this.weightage = weightage;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	@Override
	public String toString() {
		return "Answers [answerId=" + answerId + ", answer=" + answer + ", weightage=" + weightage + ", questionId="
				+ questionId + "]";
	}
	
	
}
