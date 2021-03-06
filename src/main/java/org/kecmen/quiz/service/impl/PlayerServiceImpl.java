package org.kecmen.quiz.service.impl;

import javax.annotation.Resource;

import org.kecmen.quiz.model.Player;
import org.kecmen.quiz.repository.PlayerRepository;
import org.kecmen.quiz.service.PlayerService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class PlayerServiceImpl implements PlayerService {

	@Resource
	PlayerRepository playerRepository;

	@Override
	public Player savePlayer(Player player) {
		return playerRepository.save(player);
	}

	@Override
	public Iterable<Player> getPlayerByName(String name) {
		return playerRepository.findPlayerByName(name);
	}

	@Override
	public Player findPlayerById(int id) {
		return playerRepository.findOne(id);
	}

}
