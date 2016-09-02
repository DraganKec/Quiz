package org.kecmen.quiz.repository;

import org.kecmen.quiz.model.Answers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AnswersRepository extends CrudRepository<Answers, Integer> {

	Iterable<Answers> getAllByQuestionid(int questionid);

	Answers getByAnswer(String answer);

	@Query("SELECT answer FROM Answers where correctAnswer=true AND questionid= ?1")
	Answers findBycorrectAnswer(int questionid);

}
