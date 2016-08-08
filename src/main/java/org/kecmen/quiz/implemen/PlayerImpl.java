package org.kecmen.quiz.implemen;

import javax.annotation.Resource;

import org.kecmen.quiz.Player;
import org.kecmen.quiz.repository.PlayerRepository;
import org.kecmen.quiz.service.PlayerService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class PlayerImpl implements PlayerService {

	@Resource
	PlayerRepository playerRepository;

	@Override
	public Player savePlayer(Player player) {
		playerRepository.save(player);
		return player;

	}

	@Override
	public Iterable<Player> getAllPlayers() {
		return playerRepository.findAll();
	}

}
