package org.kecmen.quiz.repository;

import org.kecmen.quiz.model.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Integer> {

	Player findPlayerByName(String name);
	
	
}
