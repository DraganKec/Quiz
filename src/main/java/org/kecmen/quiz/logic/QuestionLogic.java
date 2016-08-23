package org.kecmen.quiz.logic;

import java.util.ArrayList;
import java.util.Random;
import org.kecmen.quiz.model.Question;
import org.kecmen.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionLogic {

	@Autowired
	private QuestionService questionService;

	private ArrayList<Question> questionsList;

	private Question question;

	private ArrayList<Question> askedQuestions = new ArrayList<Question>();

	private Random random = new Random();

	public void setQuestion() {

		boolean isEmpty = true;

		do {
			question = questionService
					.findQuestionById(questionsList.get(getRandomNumber(questionsList.size())).getQuestionid());
			if (isAsked(question) == false) {
				isEmpty = false;
				askedQuestions.add(question);
			}

		} while (isEmpty);
	}

	public int getRandomNumber(int max) {
		return random.nextInt(max) + 0;
	}

	public boolean isAsked(Question question) {

		if (askedQuestions.isEmpty()) {
			return false;
		}

		for (int i = 0; i < askedQuestions.size(); i++) {
			if (askedQuestions.get(i).getQuestionid() == question.getQuestionid()) {
				return true;
			}
		}
		return false;
	}

	public Question getQuestion() {
		return question;
	}

	public ArrayList<Question> getAskedQuestions() {
		return askedQuestions;
	}

	public void setQuestionsList(ArrayList<Question> questionsList) {
		this.questionsList = questionsList;
	}

	public void clearAskedQuestions() {
		askedQuestions.clear();
	}

}
