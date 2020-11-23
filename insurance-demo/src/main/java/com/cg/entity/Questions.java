package com.cg.entity;

public class Questions {
	
	private int questionId;
	private String question;
	
	public Questions() {}

	public Questions(int questionId, String question) {
		super();
		this.questionId = questionId;
		this.question = question;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Questions [questionId=" + questionId + ", question=" + question + "]";
	}
	
	

}
