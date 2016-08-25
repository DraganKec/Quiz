package org.kecmen.quiz.service;

import org.kecmen.quiz.model.Answers;

public interface AnswersService {
	
	Iterable <Answers> getAnswer(int questionid);
	
	Answers getAnswer (String answer);
	
	String findTrueQuestion(int questionid);
}
