package org.kecmen.quiz.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "answer")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@ManyToOne
    @JoinColumn(name = "questionid")
	private Question questionid;

	private String answer;

	@Column(name = "correct_answer")
	private boolean correctAnswer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public boolean isCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(boolean correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public Question getQuestion() {
		return questionid;
	}

	public void setQuestion(Question question) {
		this.questionid = question;
	}
	
	
}
