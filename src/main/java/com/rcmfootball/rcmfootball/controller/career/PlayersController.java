package com.rcmfootball.rcmfootball.controller.career;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcmfootball.rcmfootball.request.career.PlayersRequest;
import com.rcmfootball.rcmfootball.request.career.PlayersSkillsRequest;
import com.rcmfootball.rcmfootball.request.career.UpdatePlayersReq;
import com.rcmfootball.rcmfootball.response.career.PlayerSkillResponse;
import com.rcmfootball.rcmfootball.response.career.PlayersResponse;
import com.rcmfootball.rcmfootball.service.career.PlayersService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/player")
public class PlayersController {
	@Autowired
	private PlayersService playersService;
	
	@GetMapping("/character/profile")
	public PlayersResponse playerCharacterProfile() {
		return playersService.playerCharacterProfile("SeuMadruga");
	}
	
	@PostMapping("/character/save")
	public PlayersResponse savePlayerOfUser(@RequestBody @Valid PlayersRequest playerReq) {
		return playersService.savePlayerOfUser(playerReq, "SeuMadruga");
	}
	@PatchMapping("/character/update")
	public PlayersResponse updadePlayerOfUser(@RequestBody @Valid UpdatePlayersReq playerReq) {
		return playersService.updatePlayerOfUser(playerReq, "SeuMadruga");
	}
	@DeleteMapping("character/delete/{id}")
	public ResponseEntity<Void> deletePlayerOfUser(@PathVariable Long id){
		return playersService.deletePlayerCharacter(id, "SeuMadruga");
	}
	
	
	@PostMapping("/teammate/save")
	public PlayersResponse savePlayerTeammade(@RequestBody @Valid PlayersRequest playerReq) {
		return playersService.savePlayerTeammate(playerReq);
	}
	@PatchMapping("/teammate/update/{id}")
	public PlayersResponse updatePlayerTeammate(@PathVariable Long id, @RequestBody @Valid UpdatePlayersReq playerReq) {
		return playersService.updatePlayerTeammate(playerReq, id);
	}
	@DeleteMapping("/teammate/delete/{id}")
	public ResponseEntity<Void> deletePlayersTeammate(@PathVariable Long id) {
		return playersService.deletePlayerTeammate(id, "SeuMadruga");
	}
	
	
	@GetMapping("/skills/character")
	public PlayerSkillResponse skillsByPlayerCharacter() {
		return playersService.findSkillByPlayerCharacter("SeuMadruga");
	}
	@PostMapping("/skills/character/save")
	public PlayerSkillResponse savePlayerSkill(@Valid @RequestBody PlayersSkillsRequest skillReq) {
		return playersService.createSkillsPlayerCharacter(skillReq, "SeuMadruga");
	}
	@PatchMapping("/skills/character/update/{id}")
	public PlayerSkillResponse updatePlayerSkill(@PathVariable Long id, @Valid @RequestBody PlayersSkillsRequest skillReq) {
		return playersService.updateSkillsPlayerCharacter(skillReq, "SeuMadruga");
	}
}
