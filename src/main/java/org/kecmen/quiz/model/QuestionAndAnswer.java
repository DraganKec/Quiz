package org.kecmen.quiz.model;

public class QuestionAndAnswer {

	private int questionid;
	private String question;
	private String answer;
	private String trueAnswer;

	public QuestionAndAnswer(int questionid, String question, String answer, String trueAnswer) {
		this.questionid = questionid;
		this.question = question;
		this.answer = answer;
		this.trueAnswer = trueAnswer;
	}

	public int getQuestionid() {
		return questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getTrueAnswer() {
		return trueAnswer;
	}

	public void setTrueAnswer(String trueAnswer) {
		this.trueAnswer = trueAnswer;
	}

}
