package org.kecmen.quiz.controller;

import javax.servlet.http.HttpSession;

import org.kecmen.quiz.logic.QuestionLogic;
import org.kecmen.quiz.model.Question;
import org.kecmen.quiz.service.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuestionsController {

	@Autowired
	private AnswersService answersService;
	
	private String category;
	
	@Autowired
	private QuestionLogic questionLogic;

	private Question question;

	@RequestMapping("/anotherQuestions")
	public String getQuestion(HttpSession session, ModelMap model) {
		
		questionLogic.setQuestion();

		model.addAttribute("title",questionLogic.getQuestion().getQuestion());
		model.addAttribute("questionList",answersService.getAnswer(questionLogic.getQuestion().getQuestionid()));
		

		return "questions";
	}

}
