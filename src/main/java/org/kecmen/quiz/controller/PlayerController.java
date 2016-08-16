package org.kecmen.quiz.controller;

import javax.servlet.http.HttpSession;
import org.kecmen.quiz.logic.QuestionLogic;
import org.kecmen.quiz.service.AnswersService;
import org.kecmen.quiz.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlayerController {

	@Autowired
	private QuestionLogic questionLogic;
	
	@Autowired
	private AnswersService answersService;

	@Autowired
	private PlayerService playerService;

	@RequestMapping("/questions")
	public String savePlayer(HttpSession session, ModelMap model, @RequestParam String name, String category,
			int numberQuestions) {

		questionLogic.setCategory(category);
		questionLogic.setQuestion();

		model.addAttribute("title",questionLogic.getQuestion().getQuestion());
		model.addAttribute("questionList",answersService.getAnswer(questionLogic.getQuestion().getQuestionid()));
		return "questions";
	}

	@RequestMapping("/allPlayers")
	public String allPlayers(ModelMap model, @RequestParam String category) {
		model.addAttribute("allPlayers", playerService.getAllPlayers());
		return "AllPlayers";
	}
}
