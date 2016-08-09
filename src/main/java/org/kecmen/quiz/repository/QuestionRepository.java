package org.kecmen.quiz.repository;

import org.kecmen.quiz.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Integer> {

	Iterable<Question> findByCategory(String category);

	Iterable<Question> findByQuestion(String question);
}
