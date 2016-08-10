package org.kecmen.quiz.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.kecmen.quiz.model.Question;
import org.kecmen.quiz.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@Autowired
	private QuestionLogic questionLogic;

	@RequestMapping("/questions")
	public String savePlayer(HttpSession session, ModelMap model, @RequestParam String name, String category,
			int numberQuestions) {

		
		questionLogic.setCategory(category);
		questionLogic.setNumberQuestions(numberQuestions);

		ArrayList<Question> questionList = questionLogic.getQuestion();

		model.addAttribute("title", questionList.get(0).getQuestion());
		model.addAttribute("questionList", questionList);

		return "questions";
	}

	@RequestMapping("/allPlayers")
	public String allPlayers(ModelMap model, @RequestParam String category) {
		model.addAttribute("allPlayers", playerService.getAllPlayers());
		return "AllPlayers";
	}
}
