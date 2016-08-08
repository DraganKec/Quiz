package org.kecmen.quiz.repository;

import org.kecmen.quiz.Questions;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Questions, Integer> {

}
