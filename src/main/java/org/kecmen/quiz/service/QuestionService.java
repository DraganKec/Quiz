package org.kecmen.quiz.service;

import org.kecmen.quiz.model.Category;
import org.kecmen.quiz.model.Question;

public interface QuestionService {	

	Iterable<Question> findQuestionsByCategory(Category category);

	Question findQuestionById(int id);
}
