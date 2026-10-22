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

import com.rcmfootball.rcmfootball.request.career.ManagersRequest;
import com.rcmfootball.rcmfootball.request.career.UpdateManagersReq;
import com.rcmfootball.rcmfootball.response.career.ManagersResponse;
import com.rcmfootball.rcmfootball.service.career.ManagerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/manager")
public class ManagersController {
	@Autowired
	private ManagerService managerService;
	String user = "SeuMadruga";
	
	@GetMapping("/character/profile")
	public ManagersResponse managerCharacterProfile() {
		return managerService.managerCharacterProfile(user);
	}
	@PostMapping("/character/save")
	public ManagersResponse createManagerCharacter(@RequestBody @Valid ManagersRequest managerReq) {
		return managerService.createManagerCharacter(managerReq, user);
	}
	@PatchMapping("/character/update")
	public ManagersResponse updateManagerCharacter(@RequestBody @Valid UpdateManagersReq managerReq) {
		return managerService.updateManagerCharacter(managerReq, user);
	}
	
	
	@GetMapping("/manager-mode/all")
	public List<ManagersResponse> allManagersOfUser(){
		return managerService.findAllManagersByUser(user);
	}
	@PostMapping("manager-mode/save")
	public ManagersResponse createManager(@RequestBody @Valid ManagersRequest managerReq) {
		return managerService.createManager(managerReq, user);
	}
	@PatchMapping("manager-mode/update/{id}")
	public ManagersResponse updateManager(@RequestBody @Valid UpdateManagersReq managerReq, @PathVariable Long id) {
		return managerService.updateManager(managerReq, id);
	}
	
	
	@GetMapping("/player-mode/all")
	public List<ManagersResponse> allManagerPlayerMode(String username) {
		return managerService.allManagerOfPlayerMode(username);
	}
	@PostMapping("/player-mode/save")
	public ManagersResponse createManagerPlayerMode(@RequestBody @Valid ManagersRequest managerReq) {
		return managerService.createManagerPlayerMode(managerReq, user);
	}
	@PatchMapping("/player-mode/update/{id}")
	public ManagersResponse updateManagerPlayerMode(@RequestBody @Valid UpdateManagersReq managerReq, @PathVariable Long id) {
		return managerService.updateManagerPlayerMode(managerReq, id, user);
	}
	
}
