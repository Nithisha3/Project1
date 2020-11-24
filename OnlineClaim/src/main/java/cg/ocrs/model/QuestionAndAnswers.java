package com.cg.model;

import java.util.ArrayList;

public class QuestionAndAnswers {
	private String Question;
	private int questionId;
	private ArrayList<String> Answers;
	public QuestionAndAnswers() {
		Answers = new ArrayList<String>();
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public ArrayList<String> getAnswers() {
		return Answers;
	}
	public void setAnswers(ArrayList<String> answers) {
		Answers = answers;
	}
	@Override
	public String toString() {
		return "QuestionAndAnswers [Question=" + Question + ", Answers=" + Answers + "]";
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	
}
