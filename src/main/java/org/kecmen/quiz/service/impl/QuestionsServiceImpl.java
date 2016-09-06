package org.kecmen.quiz.service.impl;

import javax.annotation.Resource;

import org.kecmen.quiz.model.Category;
import org.kecmen.quiz.model.Question;
import org.kecmen.quiz.repository.QuestionRepository;
import org.kecmen.quiz.service.QuestionService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class QuestionsServiceImpl implements QuestionService {

	@Resource
	private QuestionRepository questionRepository;

	@Override
	public Iterable<Question> findQuestionsByCategory(Category category) {
		return questionRepository.getAllByCategory(category);
	}

	@Override
	public Question findQuestionById(int id) {
		return questionRepository.findOne(id);
	}

}
