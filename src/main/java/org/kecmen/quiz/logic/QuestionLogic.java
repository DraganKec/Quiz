package org.kecmen.quiz.logic;

import java.util.ArrayList;
import java.util.Random;
import org.kecmen.quiz.model.*;
import org.kecmen.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionLogic {

	private QuestionService questionService;
	private ArrayList<Question> questionsList;
	private ArrayList<Question> askedQuestion = new ArrayList<Question>();
	private Question question;
	private Random random = new Random();
	
	@Autowired
	public QuestionLogic(QuestionService questionService) {
	    this.questionService = questionService;
	}

	public void setQuestion() {
		boolean isEmpty = true;

		do {
			question = questionService
					.findQuestionById(questionsList.get(getRandomNumber(questionsList.size())).getQuestionid());
			if (!isAsked(question)) {				
				isEmpty = false;
			}			
			askedQuestion.add(question);

		} while (isEmpty);
	}

	public int getRandomNumber(int max) {
		return random.nextInt(max);
	}

	public boolean isAsked(Question question) {

		if (askedQuestion.isEmpty()) {
			return false;
		}

		for (Question asked : askedQuestion) {
			if (asked.getQuestionid() == question.getQuestionid()) {
				return true;
			}
		}
		return false;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestionsList(ArrayList<Question> questionsList) {
		this.questionsList = questionsList;
	}

}
