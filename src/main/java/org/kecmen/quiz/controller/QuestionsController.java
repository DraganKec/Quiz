package org.kecmen.quiz.controller;

import javax.servlet.http.HttpSession;

import org.kecmen.quiz.logic.QuestionLogic;
import org.kecmen.quiz.service.AnswersService;
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

	private int numberOfQuestion;
	
	private int results;

	@Autowired
	private QuestionLogic questionLogic;

	@RequestMapping("/anotherQuestions")
	public String getQuestion(HttpSession session, ModelMap model, @RequestParam String playersAnswer) {

		if (answersService.getAnswer(playersAnswer).isCorrectAnswer()) {
			results ++;
		}

		questionLogic.setQuestion();
		model.addAttribute("results", results);
		model.addAttribute("title", questionLogic.getQuestion().getQuestion());
		model.addAttribute("questionList", answersService.getAnswer(questionLogic.getQuestion().getQuestionid()));

		numberOfQuestion--;

		if (numberOfQuestion == 0) {
			return "results";
		}

		return "questions";
	}

	public void setNumberOfQuestion(int numberOfQuestion) {
		this.numberOfQuestion = numberOfQuestion;
	}

}
