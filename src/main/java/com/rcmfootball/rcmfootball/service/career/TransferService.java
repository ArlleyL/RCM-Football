package com.rcmfootball.rcmfootball.service.career;

import com.rcmfootball.rcmfootball.request.career.TransferRequest;
import com.rcmfootball.rcmfootball.response.career.TransferResponse;

public interface TransferService {

	TransferResponse transferPlayer(TransferRequest transferReq, String username, Long idPlayer, Long idTeam);

	TransferResponse UpdateTransferPlayer(TransferRequest transferReq, Long idTransfer, Long idPlayer, String username);

	void deleteTransferHistory(Long idTransfer, Long idPlayer, String username);

}
