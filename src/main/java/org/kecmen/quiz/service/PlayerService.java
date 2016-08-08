package org.kecmen.quiz.service;

import org.kecmen.quiz.Player;

public interface PlayerService {
	
	Player savePlayer(Player player);
	
	Iterable<Player> getAllPlayers();
	
	
}
