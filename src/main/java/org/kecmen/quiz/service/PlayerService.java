package org.kecmen.quiz.service;

import org.kecmen.quiz.model.Player;

public interface PlayerService {

	Player savePlayer(Player player);


	Player getPlayerByName(String name);
	
	Player findPlayerById (int id);

}
