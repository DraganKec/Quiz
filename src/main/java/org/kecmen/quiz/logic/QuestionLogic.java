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

	private String category;

	private Question question;

	private ArrayList<Integer> askedQuestions = new ArrayList<Integer>();

	private Random random = new Random();

	public void setQuestion() {

		boolean isEmpty = true;

		questionsList = (ArrayList<Question>) questionService.findQuestionsByCategory(category);

		do {
			question = questionService
					.findQuestionById(questionsList.get(getRandomNumber(questionsList.size())).getQuestionid());
			if (isAsked(question) == false) {
				isEmpty = false;
				askedQuestions.add(question.getQuestionid());
			}

		} while (isEmpty);
	}

	public int getRandomNumber(int max) {
		return random.nextInt(max) + 0;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isAsked(Question question) {

		if (askedQuestions.isEmpty()) {
			return false;
		}

		for (int i = 0; i < askedQuestions.size(); i++) {
			if (askedQuestions.get(i) == question.getQuestionid()) {
				return true;
			}
		}
		return false;
	}

	public Question getQuestion() {
		return question;
	}

}