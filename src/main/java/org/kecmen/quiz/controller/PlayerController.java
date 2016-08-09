package org.kecmen.quiz.controller;

import org.kecmen.quiz.model.Player;
import org.kecmen.quiz.model.Question;
import org.kecmen.quiz.service.PlayerService;
import org.kecmen.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@Autowired
	private QuestionService questionService;

	@RequestMapping("/questions")
	public String savePlayer(ModelMap model, @RequestParam String name, String category, int numberQuestions) {
		

		model.addAttribute("questionList", questionService.findQuestionsByCategory(category));


		return "questions";
	}

	@RequestMapping("/allPlayers")
	public String allPlayers(ModelMap model, @RequestParam String category) {
		model.addAttribute("allPlayers", playerService.getAllPlayers());
		return "AllPlayers";
	}
}
