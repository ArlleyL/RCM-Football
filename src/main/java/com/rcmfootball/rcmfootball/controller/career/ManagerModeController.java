package com.rcmfootball.rcmfootball.controller.career;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcmfootball.rcmfootball.request.career.ManagersRequest;
import com.rcmfootball.rcmfootball.request.career.UpdateManagersReq;
import com.rcmfootball.rcmfootball.response.career.ManagersResponse;
import com.rcmfootball.rcmfootball.service.career.ManagerModeService;

@RestController
@RequestMapping("/manager")
public class ManagerModeController {
	@Autowired
	private ManagerModeService managerModeService;
	
	@PostMapping("/character/save")
	public ManagersResponse createManagerCharacter(@RequestBody ManagersRequest managerReq) {
		return managerModeService.createManagerCharacter(managerReq, "SeuMadruga");
	}
	@PatchMapping("/character/update")
	public ManagersResponse updateManagerCharacter(@RequestBody UpdateManagersReq managerReq) {
		return managerModeService.updateManagerCharacter(managerReq, "SeuMadruga");
	}
	
	
	@PostMapping("/save")
	public ManagersResponse createManager(@RequestBody ManagersRequest managerReq) {
		return managerModeService.createManager(managerReq, "SeuMadruga");
	}
	@PatchMapping("/update/{id}")
	public ManagersResponse updateManager(@RequestBody UpdateManagersReq managerReq, @PathVariable Long id) {
		return managerModeService.updateManager(managerReq, id);
	}
	
	
	@PostMapping("/player-mode/save")
	public ManagersResponse createManagerPlayerMode(@RequestBody ManagersRequest managerReq) {
		return managerModeService.createManagerPlayerMode(managerReq, "SeuMadruga");
	}
	@PatchMapping("/player-mode/update")
	public ManagersResponse updateManagerPlayerMode(@RequestBody UpdateManagersReq managerReq, @PathVariable Long id) {
		return managerModeService.updateManagerPlayerMode(managerReq, id);
	}
	
}
