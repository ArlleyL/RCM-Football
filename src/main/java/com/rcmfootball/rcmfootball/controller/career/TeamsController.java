package com.rcmfootball.rcmfootball.controller.career;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcmfootball.rcmfootball.request.career.TeamsRequest;
import com.rcmfootball.rcmfootball.request.career.UpdateTeamReq;
import com.rcmfootball.rcmfootball.response.career.TeamsResponse;
import com.rcmfootball.rcmfootball.service.career.TeamsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/team")
public class TeamsController {
	@Autowired
	private TeamsService teamsService;
	
	@GetMapping("/player-mode/all")
	public List<TeamsResponse> allTeamOfPlayerMode(){
		return teamsService.findAllTeamPlayerMode("SeuMadruga");
	}
	
	@PostMapping("/player-mode/save")
	public TeamsResponse saveTeamPlayer(@RequestBody @Valid TeamsRequest teamReq) {
		return teamsService.createTeamPlayerMode(teamReq, "SeuMadruga");
	}
	@PatchMapping("/player-mode/update/{id}")
	public TeamsResponse updatedTeamPlayer(@RequestBody @Valid UpdateTeamReq teamReq, @PathVariable Long id) {
		return teamsService.updateTeamPlayerMode(teamReq, "SeuMadruga", id);
	}
	
	@GetMapping("/manager-mode/all")
	public List<TeamsResponse> allTeamOfManagerMode(){
		return teamsService.findAllTeamManagerMode("SeuMadruga");
	}
	
	@PostMapping("/manager-mode/save")
	public TeamsResponse saveTeamManager(@RequestBody @Valid TeamsRequest teamReq) {
		return teamsService.createTeamManagerMode(teamReq, "SeuMadruga");
	}
	@PatchMapping("/manager-mode/update/{id}")
	public TeamsResponse updatedTeamManager(@RequestBody @Valid UpdateTeamReq teamReq, @PathVariable Long id) {
		return teamsService.updateTeamManagerMode(teamReq, "SeuMadruga", id);
	}
}
