package org.kecmen.quiz.service;

import org.kecmen.quiz.model.Answers;

public interface AnswersService {

	Answers getAnswer(String answer);

	Answers getAnswerById(int id);

	Answers findTrueAnswer(int questionid);
}
