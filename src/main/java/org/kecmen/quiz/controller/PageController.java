package org.kecmen.quiz.controller;

import java.util.Set;

import org.kecmen.quiz.model.Answers;
import org.kecmen.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@Autowired
	private QuestionRepository repository;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/test")
	public String test() {
		System.out.println(repository.findOne(7).getAnswers());
		 Set<Answers> answersList = repository.findOne(7).getAnswers();
		return "index";
	}

}
