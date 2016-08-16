package org.kecmen.quiz.service.impl;

import javax.annotation.Resource;

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
	public Question saveQuestion(Question questions) {
		return questionRepository.save(questions);
	}

	@Override
	public Iterable<Question> getAllQuestions() {
		return questionRepository.findAll();
	}

	@Override
	public Iterable<Question> findQuestionsByCategory(String category) {
		return questionRepository.getAllByCategory(category);
	}

	@Override
	public Iterable<Question> findQuestion(String question) {
		return questionRepository.getAllByCategory(question);
	}

	@Override
	public Question findQuestionById(int id) {
		return questionRepository.findOne(id);
	}

}
