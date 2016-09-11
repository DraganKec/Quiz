package org.kecmen.quiz.controller;

import java.util.ArrayList;
import org.kecmen.quiz.logic.QuestionLogic;
import org.kecmen.quiz.model.Question;
import org.kecmen.quiz.service.CategoryService;
import org.kecmen.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlayerController {

	@Autowired
	private QuestionLogic questionLogic;

	@Autowired
	private QuestionsController questionsController;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private QuestionService questionService;

	@RequestMapping("/questions")
	public String savePlayer(ModelMap model, @RequestParam String playerName, int categoryid, int numberQuestions) {

		// Assigning a value
		questionsController.setResults(0);
		questionsController.setPlayerName(playerName);
		questionsController.setNumberOfQuestion(numberQuestions);
		questionLogic.setQuestionsList((ArrayList<Question>) questionService
				.findQuestionsByCategory(categoryService.findCategoryById(categoryid)));

		questionLogic.setQuestion();
	
		model.addAttribute("title", questionLogic.getQuestion().getQuestion());
		model.addAttribute("answersList", questionLogic.getQuestion().getAnswers());

		return "questions";
	}
}
