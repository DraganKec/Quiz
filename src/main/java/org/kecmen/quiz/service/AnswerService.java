package org.kecmen.quiz.service;

import org.kecmen.quiz.model.Answer;

public interface AnswerService {

	Answer getAnswer(String answer);

	Answer getAnswerById(int id);

	Answer findTrueAnswer(int questionid);
}
