package com.rcmfootball.rcmfootball.service.impl.career;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcmfootball.rcmfootball.model.career.Players;
import com.rcmfootball.rcmfootball.model.career.Teams;
import com.rcmfootball.rcmfootball.model.career.Transfer;
import com.rcmfootball.rcmfootball.model.users.Users;
import com.rcmfootball.rcmfootball.repository.career.ManagersRepository;
import com.rcmfootball.rcmfootball.repository.career.PlayersRepository;
import com.rcmfootball.rcmfootball.repository.career.TeamsRepository;
import com.rcmfootball.rcmfootball.repository.career.TransferRepository;
import com.rcmfootball.rcmfootball.repository.users.UsersRepository;
import com.rcmfootball.rcmfootball.request.career.TransferRequest;
import com.rcmfootball.rcmfootball.response.career.TransferResponse;
import com.rcmfootball.rcmfootball.service.career.TransferService;

@Service
public class TransferServiceImpl implements TransferService{
	@Autowired
	private PlayersRepository playersRepository;
	/*@Autowired
	private ManagersRepository managerRepository;*/
	@Autowired
	private TeamsRepository teamsRepository;
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private TransferRepository transferRepository;
	
	@Override
	public TransferResponse transferPlayer(TransferRequest transferReq, String username, Long idPlayer, Long idTeam) {
		Users user = usersRepository.findByUsername(username);
		Players player = playersRepository.findById(idPlayer).orElseThrow(()->new RuntimeException("Jogador não encontrado"));
		Teams team = teamsRepository.findById(idTeam).orElseThrow(()->new RuntimeException("Time não encontrado"));
		
		Transfer transfer = transferReq.toEntity();
		
		if(player.getUserCharacter() != null) {
			if(player.getUserCharacter() != user) new RuntimeException("Não é permitido alterar o jogador personagem de outro usuário");
		}
		if((player.getPlayerMode() != null && player.getUserCharacter() == null) || team.getPlayerMode() != null) {
			if(player.getPlayerMode() != user) new RuntimeException("Não é permitido alterar o jogador de outro usuário");
		}
		if(player.getManagerMode() != null || team.getManagerMode() != null) {
			if(player.getManagerMode() != user) new RuntimeException("Não é permitido alterar o jogador de outro usuário");
		}
		
		transfer.setPlayer(player);
		transfer.setOldTeam(player.getCurrentTeam());
		transfer.setNewTeam(team);
		player.setCurrentTeam(team);
		
		playersRepository.save(player);
		transferRepository.save(transfer);
		
		return TransferResponse.toDto(transfer);
	}
	
	@Override
	public TransferResponse UpdateTransferPlayer(TransferRequest transferReq, Long idTransfer, Long idPlayer, String username) {
		Users user = usersRepository.findByUsername(username);
		Players player = playersRepository.findById(idPlayer).orElseThrow(()->new RuntimeException("Nenhum jogador contrado com o id: "+idPlayer));
		
		if(player.getUserCharacter() != null) {
			if(player.getUserCharacter() != user) new RuntimeException("Não é permitido alterar o jogador personagem de outro usuário");
		}
		if(player.getPlayerMode() != null && player.getUserCharacter() == null) {
			if(player.getPlayerMode() != user) new RuntimeException("Não é permitido alterar o jogador de outro usuário");
		}
		if(player.getManagerMode() != null) {
			if(player.getManagerMode() != user) new RuntimeException("Não é permitido alterar o jogador de outro usuário");
		}
		Transfer transfer = transferRepository.findByIdTransferAndPlayer(idPlayer, player);
		
		transferReq.updateTransferDetailsPlayer(transfer);
		
		if(transfer.getIsAccepted() == false) player.setCurrentTeam(transfer.getOldTeam());
		
		playersRepository.save(player);
		transferRepository.save(transfer);
		
		return TransferResponse.toDto(transfer);
	}
	
	@Override
	public void deleteTransferHistory(Long idTransfer, Long idPlayer, String username) {
		Users user = usersRepository.findByUsername(username);
		Players player = playersRepository.findById(idPlayer).orElseThrow(()->new RuntimeException("Jogador não encontrado com o id: "+idPlayer));
		
		if(		player.getUserCharacter() != null && player.getUserCharacter() != user || 
				player.getPlayerMode() != null && player.getPlayerMode() != user ||
				player.getManagerMode() != null && player.getManagerMode() != user
			) {
			throw new RuntimeException("Não é permitido alterar o jogador de outro usuário");
		}
		
		Transfer tranferExisting = transferRepository.findByIdTransferAndPlayer(idTransfer, player);
		
		transferRepository.delete(tranferExisting);
	}
}
