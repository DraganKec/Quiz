package org.kecmen.quiz.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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


	private int numberOfQuestion;

	private int results;	

	private String playerName;

	@Autowired
	private Player player;

	@Autowired
	private QuestionLogic questionLogic;

	@RequestMapping("/anotherQuestions")
	public String getQuestion(ModelMap model, @RequestParam String playersAnswer) {
		
		if (answersService.getAnswer(playersAnswer).isCorrectAnswer()) {
			results++;
		}
		
		model.addAttribute("trueanswer", answersService.findTrueAnswer(questionLogic.getQuestion()
				.getQuestionid()).getAnswer());
		model.addAttribute("results", results);
		model.addAttribute("player", playerName);
		
		numberOfQuestion--;
		if (numberOfQuestion == 0) {
			
			Date currentDate = new Date();
			SimpleDateFormat sdf =  new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			player.setName(playerName);
			player.setResults(results);
			player.setDate(sdf.format(currentDate));
			playerService.savePlayer(player);

			model.addAttribute("playerresults", playerService.getPlayerByName(playerName));			
			
			return "results";
		}
		
		questionLogic.setQuestion();

		model.addAttribute("title", questionLogic.getQuestion().getQuestion());
		model.addAttribute("answersList", questionLogic.getQuestion().getAnswers());
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
