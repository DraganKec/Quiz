package org.kecmen.quiz.service;

import org.kecmen.quiz.model.Answers;
import org.kecmen.quiz.model.Question;

public interface AnswersService {
	
//	Iterable <Answers> getAnswer(Question questionid);
	
	Answers getAnswer (String answer);
	
	Answers getAnswerById (int id);
	
	Answers findTrueQuestion(Question question);
}
