package org.kecmen.quiz.model;

public class QuestionAndAnswer {
	private int questionid;
	private String question;
	private String trueAnswer;
	private String playerAnswer;

	public QuestionAndAnswer(int questionid, String question, String trueAnswer, String playerAnswer) {
		super();
		this.questionid = questionid;
		this.question = question;
		this.trueAnswer = trueAnswer;
		this.playerAnswer = playerAnswer;
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

	public String getTrueAnswer() {
		return trueAnswer;
	}

	public void setTrueAnswer(String trueAnswer) {
		this.trueAnswer = trueAnswer;
	}

	public String getPlayerAnswer() {
		return playerAnswer;
	}

	public void setPlayerAnswer(String playerAnswer) {
		this.playerAnswer = playerAnswer;
	}

}
