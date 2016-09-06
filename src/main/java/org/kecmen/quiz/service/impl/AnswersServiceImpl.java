package org.kecmen.quiz.service.impl;

import javax.annotation.Resource;

import org.kecmen.quiz.model.Answers;
import org.kecmen.quiz.model.Question;
import org.kecmen.quiz.repository.AnswersRepository;
import org.kecmen.quiz.service.AnswersService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class AnswersServiceImpl implements AnswersService {

	@Resource
	private AnswersRepository answerReposiroty;

//	@Override
//	public Iterable<Answers> getAnswer(Question questionid) {
//		return answerReposiroty.getAllByQuestionid(questionid);
//	}

	@Override
	public Answers getAnswer(String playersAnswer) {
		return answerReposiroty.getByAnswer(playersAnswer);
	}

	@Override
	public Answers findTrueQuestion(Question question) {
		return answerReposiroty.findBycorrectAnswer(question);
	}

	@Override
	public Answers getAnswerById(int id) {
		return answerReposiroty.findOne(id);
	}

}
