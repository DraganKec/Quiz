package org.kecmen.quiz.contoller;

import java.util.Map;

import org.kecmen.quiz.Player;
import org.kecmen.quiz.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@RequestMapping("/questions")
	public String savePlayer(@RequestParam String name) {

		Player player = new Player();
		player.setName(name);

		System.out.println(name);
		playerService.savePlayer(player);

		return "questions";
	}

	@RequestMapping("/allPlayers")
	public String allPlayers(ModelMap model) {
		model.addAttribute("allPlayers", playerService.getAllPlayers());
		return "AllPlayers";
	}
}
