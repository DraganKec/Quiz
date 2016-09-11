package org.kecmen.quiz.repository;

import org.kecmen.quiz.model.Answer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Integer> {

	Answer getByAnswer(String answer);

	@Query("SELECT a FROM Answer a LEFT JOIN a.questionid q WHERE a.correctAnswer=true AND q.questionid= ?1")
	Answer findBycorrectAnswer(int question);

}
