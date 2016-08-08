package org.kecmen.quiz.service;

import org.kecmen.quiz.Questions;

public interface QuestionsService {
	
	Questions saveQuestion(Questions questions);
	
	Iterable<Questions> getAllQuestions();
	
	Iterable<Questions> findQuestionsByCategory (String category);
}
