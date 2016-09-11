package org.kecmen.quiz.controller;


import java.util.ArrayList;

import org.kecmen.quiz.logic.QuestionLogic;
import org.kecmen.quiz.model.Answers;
import org.kecmen.quiz.model.Question;
import org.kecmen.quiz.repository.QuestionRepository;
import org.kecmen.quiz.service.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@Autowired
	private QuestionRepository repository;
	
	@Autowired
	private QuestionLogic questionLogic;
	
	@Autowired
	private AnswersService service;
	
	private ArrayList<Answers> ans = new ArrayList<Answers>();

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/test")
	public String test() {
		//Question qu = repository.findOne(3);
		Question setans = questionLogic.getQuestion();
		
		Answers sd = service.findTrueAnswer(3);
		ans.add(sd);
		
//		for(QuestionAndAnswer answers1: qaa){
//			if (answers1.isCorrectAnswer()){
//				System.out.println(answers1.getTrueAnswer());
//			}
//		}
			
		return "index";
	}

}
