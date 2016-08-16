package org.kecmen.quiz.service;

import org.kecmen.quiz.model.Question;

public interface QuestionService {

	Question saveQuestion(Question questions);

	Iterable<Question> getAllQuestions();

	Iterable<Question> findQuestionsByCategory(String category);

	Iterable<Question> findQuestion(String question);

	Question findQuestionById(int id);
}
