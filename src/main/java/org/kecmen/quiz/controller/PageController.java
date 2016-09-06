package org.kecmen.quiz.controller;


import java.util.ArrayList;
import java.util.Set;

import org.kecmen.quiz.model.Answers;
import org.kecmen.quiz.model.Question;
import org.kecmen.quiz.repository.AnswersRepository;
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
	private AnswersService service;
	
	private ArrayList<Answers> ans = new ArrayList<Answers>();

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/test")
	public String test() {
		Question qu = repository.findOne(3);
		
		Set<Answers> answers = qu.getAnswers();
		
		Answers sd = service.getAnswerById(3);
		ans.add(sd);
		
		for(Answers answers1: answers){
			if (answers1.isCorrectAnswer()){
				System.out.print(answers1.getAnswer());
			}
		}
			
		return "index";
	}

}
