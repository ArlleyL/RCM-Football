package com.rcmfootball.rcmfootball.controller.career;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcmfootball.rcmfootball.request.career.TransferRequest;
import com.rcmfootball.rcmfootball.response.career.TransferResponse;
import com.rcmfootball.rcmfootball.service.career.TransferService;

@RestController
@RequestMapping("/transfer")
public class TransferController {
	@Autowired
	private TransferService transferService;
	
	@PostMapping("/player/save/{idPlayer}/{idTeam}")
	public TransferResponse transferPlayer(@RequestBody TransferRequest transferReq, @PathVariable Long idPlayer, @PathVariable Long idTeam) {
		return transferService.transferPlayer(transferReq, "SeuMadruga", idPlayer, idTeam);
	}
	@PatchMapping("/player/update/{idTransfer}/{idPlayer}")
	public TransferResponse upadateTransferPlayer(@RequestBody TransferRequest tranferReq, @PathVariable Long idTransfer, @PathVariable Long idPlayer) {
		return transferService.UpdateTransferPlayer(tranferReq, idTransfer, idPlayer, "SeuMadruga");
	}
	@DeleteMapping("/player/delete")
	public void deleteTransferPlayer(@PathVariable Long idTransfer, @PathVariable Long idPlayer) {
		transferService.deleteTransferHistory(idTransfer, idPlayer, "SeuMadruga");
	}
}
