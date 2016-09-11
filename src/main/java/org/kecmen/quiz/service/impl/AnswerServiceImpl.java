package org.kecmen.quiz.service.impl;

import javax.annotation.Resource;

import org.kecmen.quiz.model.Answer;
import org.kecmen.quiz.repository.AnswerRepository;
import org.kecmen.quiz.service.AnswerService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class AnswerServiceImpl implements AnswerService {

	@Resource
	private AnswerRepository answerReposiroty;

	@Override
	public Answer getAnswer(String playersAnswer) {
		return answerReposiroty.getByAnswer(playersAnswer);
	}

	@Override
	public Answer findTrueAnswer(int questionid) {
		return answerReposiroty.findBycorrectAnswer(questionid);
	}

	@Override
	public Answer getAnswerById(int id) {
		return answerReposiroty.findOne(id);
	}

}
