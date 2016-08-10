package org.kecmen.quiz.controller;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.kecmen.quiz.model.Question;
import org.kecmen.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuestionLogic {

	@Autowired
	private QuestionService questionService;

	private String category;
	private int numberQuestions;

	private Random random = new Random();

	@RequestMapping("/anotherQuestions")
	public String savePlayer(HttpSession session, ModelMap model) {

		ArrayList<Question> questionList = getQuestion();

		model.addAttribute("title", questionList.get(0).getQuestion());
		model.addAttribute("questionList", questionList);

		return "questions";
	}

	public ArrayList<Question> getQuestion() {

		ArrayList<Question> questionsList = (ArrayList<Question>) questionService.findQuestionsByCategory(category);

		ArrayList<Question> oneQuestion = (ArrayList<Question>) questionService
				.findQuestion(questionsList.get(getRandomNumber(questionsList.size())).getQuestion());

		return oneQuestion;
	}

	public int getRandomNumber(int max) {
		return random.nextInt(max) + 0;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setNumberQuestions(int numberQuestions) {
		this.numberQuestions = numberQuestions;
	}

}
