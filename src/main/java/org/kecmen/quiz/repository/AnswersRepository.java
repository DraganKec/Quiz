package org.kecmen.quiz.repository;

import org.kecmen.quiz.model.Answers;
import org.kecmen.quiz.model.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AnswersRepository extends CrudRepository<Answers, Integer> {

	Iterable<Answers> getAllByQuestionid(Question question);

	Answers getByAnswer(String answer);

	@Query("SELECT a FROM Answers a LEFT JOIN a.questionid q WHERE a.correctAnswer=true AND q.questionid= ?1")
	Answers findBycorrectAnswer(int question);

}
