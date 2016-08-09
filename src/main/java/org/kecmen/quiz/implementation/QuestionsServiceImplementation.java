package org.kecmen.quiz.implementation;

import javax.annotation.Resource;

import org.kecmen.quiz.model.Question;
import org.kecmen.quiz.repository.QuestionRepository;
import org.kecmen.quiz.service.QuestionService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class QuestionsServiceImplementation implements QuestionService {

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
		return questionRepository.findByCategory(category);
	}

	@Override
	public Iterable<Question> findQuestion(String question) {
		return questionRepository.findByQuestion(question);
	}

}
