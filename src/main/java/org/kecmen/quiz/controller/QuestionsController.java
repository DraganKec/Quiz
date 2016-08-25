package org.kecmen.quiz.controller;

import java.util.Date;
import javax.servlet.http.HttpSession;
import org.kecmen.quiz.logic.QuestionLogic;
import org.kecmen.quiz.model.Player;
import org.kecmen.quiz.service.AnswersService;
import org.kecmen.quiz.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Component
public class QuestionsController {

	@Autowired
	private AnswersService answersService;

	@Autowired
	private PlayerService playerService;

	Date date = new Date();

	private int numberOfQuestion;

	private int results;

	private String playerName;

	@Autowired
	private Player player;

	@Autowired
	private QuestionLogic questionLogic;

	@RequestMapping("/anotherQuestions")
	public String getQuestion(HttpSession session, ModelMap model, @RequestParam String playersAnswer) {

		if (answersService.getAnswer(playersAnswer).isCorrectAnswer()) {
			results++;
		}

		numberOfQuestion--;
		if (numberOfQuestion == 0) {

			Player existingPlayer = playerService.getPlayerByName(playerName);

			if (existingPlayer != null) {
				player.setId(existingPlayer.getId());
			}
			player.setName(playerName);
			player.setResults(results);

			playerService.savePlayer(player);
			model.addAttribute("askedquestion", questionLogic.getAskedQuestions());
			model.addAttribute("results", results);
			model.addAttribute("player", playerName);
			return "results";
		}

		questionLogic.setQuestion();

		model.addAttribute("title", questionLogic.getQuestion().getQuestion());
		model.addAttribute("questionList", answersService.getAnswer(questionLogic.getQuestion().getQuestionid()));

		return "questions";
	}

	public void setNumberOfQuestion(int numberOfQuestion) {
		this.numberOfQuestion = numberOfQuestion;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public void setResults(int results) {
		this.results = results;
	}

}
