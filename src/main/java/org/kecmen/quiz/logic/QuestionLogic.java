package org.kecmen.quiz.logic;

import java.util.ArrayList;
import java.util.Random;
import org.kecmen.quiz.model.*;
import org.kecmen.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionLogic {

	@Autowired
	private QuestionService questionService;

	private ArrayList<Question> questionsList;

	private ArrayList<QuestionAndAnswer> questionAndAnswerList;

	private Question question;

	private Random random = new Random();

	public void setQuestion() {

		boolean isEmpty = true;

		do {
			question = questionService
					.findQuestionById(questionsList.get(getRandomNumber(questionsList.size())).getQuestionid());
			if (!isAsked(question)) {
				isEmpty = false;

			}

		} while (isEmpty);
	}

	public int getRandomNumber(int max) {
		return random.nextInt(max);
	}

	public boolean isAsked(Question question) {

		if (questionAndAnswerList.isEmpty()) {
			return false;
		}

		for (QuestionAndAnswer qestionAndAnswer : questionAndAnswerList) {
			if (qestionAndAnswer.getQuestionid() == question.getQuestionid()) {
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

	public void questionAndAnswerList() {
		questionAndAnswerList.clear();
	}

	public ArrayList<QuestionAndAnswer> getQuestionAndAnswerList() {
		return questionAndAnswerList;
	}

	public void addQuestionAndAnswer(QuestionAndAnswer questionAndAnswer) {
		this.questionAndAnswerList.add(questionAndAnswer);
	}

	public void clearQuestionAndAnswerList() {
		questionAndAnswerList.clear();
	}

}
