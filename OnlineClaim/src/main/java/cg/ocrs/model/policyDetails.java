package cg.ocrs.model;

public class policyDetails {
	private Integer policyNumber;
	private String questionId;
	private String answer;
	public Integer getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(Integer policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public policyDetails(Integer policyNumber, String questionId, String answer) {
		super();
		this.policyNumber = policyNumber;
		this.questionId = questionId;
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "policyDetails [policyNumber=" + policyNumber + ", questionId=" + questionId + ", answer=" + answer
				+ "]";
	}

}
