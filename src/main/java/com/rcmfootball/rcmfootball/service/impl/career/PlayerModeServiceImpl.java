package com.rcmfootball.rcmfootball.service.impl.career;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rcmfootball.rcmfootball.model.career.Nationality;
import com.rcmfootball.rcmfootball.model.career.Players;
import com.rcmfootball.rcmfootball.model.career.PlayersSkills;
import com.rcmfootball.rcmfootball.model.users.Users;
import com.rcmfootball.rcmfootball.repository.career.NationsRepository;
import com.rcmfootball.rcmfootball.repository.career.PlayerSkillRepository;
import com.rcmfootball.rcmfootball.repository.career.PlayersRepository;
import com.rcmfootball.rcmfootball.repository.users.UsersRepository;
import com.rcmfootball.rcmfootball.request.career.PlayersRequest;
import com.rcmfootball.rcmfootball.request.career.PlayersSkillsRequest;
import com.rcmfootball.rcmfootball.request.career.UpdatePlayersReq;
import com.rcmfootball.rcmfootball.response.career.PlayerSkillResponse;
import com.rcmfootball.rcmfootball.response.career.PlayersResponse;
import com.rcmfootball.rcmfootball.service.career.PlayerModeService;


@Service
public class PlayerModeServiceImpl implements PlayerModeService{
	@Autowired
	private PlayersRepository playersRepository;
	@Autowired
	private NationsRepository nationsRepository;
	@Autowired
	private PlayerSkillRepository playerSkillRepository;
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public PlayersResponse savePlayerOfUser(PlayersRequest playerReq, String username) {
		Users userCharacter = usersRepository.findByUsername("SeuMadruga");
		Players playerExisting = playersRepository.findByUserCharacterAndPlayerMode(userCharacter, userCharacter);
		
		if(Objects.nonNull(playerExisting)) {
			throw new RuntimeException("É possivel criar apenas um jogador personagem");
		}
		
		Players player = playerReq.toEntity();
		Nationality nation = nationsRepository.findByCod(playerReq.getNation());
		player.setNation(nation);
		player.setPlayerMode(userCharacter);
		player.setUserCharacter(userCharacter);
		playersRepository.save(player);
		
		return PlayersResponse.toDto(player);
	}
	
	@Override
	public PlayersResponse updatePlayerOfUser(UpdatePlayersReq playerReq, String username) {
		Users user = usersRepository.findByUsername(username);
		Players player = playersRepository.findByUserCharacterAndPlayerMode(user, user);
		
		playerReq.updatedPlayer(player);
		
		playersRepository.save(player);
		
		return PlayersResponse.toDto(player);
	}
	
	@Override
	public ResponseEntity<Void> deletePlayerCharacter(Long id, String username){
		Players player = playersRepository.findById(id).orElseThrow(()->new RuntimeException("Não encontrado o jogador com id "+id));
		Users user = usersRepository.findByUsername(username);
		
		if(user != player.getUserCharacter() || player.getUserCharacter() == null) {
			throw new RuntimeException("Não é possivel excluir um jogador que não pertença ao usuário");
		}
		
		PlayersSkills playerSkills = playerSkillRepository.findByPlayer(player);
		
		playerSkillRepository.delete(playerSkills);
		playersRepository.delete(player);
		
		return ResponseEntity.noContent().build();
	}
	
	@Override
	public PlayersResponse savePlayerTeammate(PlayersRequest playerReq) {
		Users user = usersRepository.findByUsername("SeuMadruga");
		List<Players> playersExisting = playersRepository.findByPlayerMode(user);
		
		Players playerCharacter = playersRepository.findByUserCharacterAndPlayerMode(user, user);
		
		if(playersExisting.size() > 8) {
			throw new RuntimeException("Limite atingido de companheiros de time");
		}
		
		Players player = playerReq.toEntity();
		Nationality nation = nationsRepository.findByCod(playerReq.getNation());
		player.setNation(nation);
		player.setPlayerMode(user);
		player.setCurrentTeam(playerCharacter.getCurrentTeam());
		
		playersRepository.save(player);
		return PlayersResponse.toDto(player);
	}
	
	@Override
	public PlayersResponse updatePlayerTeammate(UpdatePlayersReq playerReq, Long id) {
		Players player = playersRepository.findById(id).orElseThrow(()->new RuntimeException("Player não encontrado com o id: "+id));
		
		if(player.getUserCharacter() != null) {
			throw new RuntimeException("Não foi possivel atualizar o jogador");
		}
		
		playerReq.updatedPlayer(player);
		
		playersRepository.save(player);
		
		return PlayersResponse.toDto(player);	
	}
	
	@Override
	public ResponseEntity<Void> deletePlayerTeammate(Long id, String username){
		Players player = playersRepository.findById(id).orElseThrow(()->new RuntimeException("Não encontrado o jogador com id "+id));
		Users user = usersRepository.findByUsername(username);
		
		if(user != player.getPlayerMode() || player.getPlayerMode() == null) {
			throw new RuntimeException("Não é possivel excluir um jogador que não perteça ao usuário");
		}
		playersRepository.delete(player);
		
		return ResponseEntity.noContent().build();
	}
	
	@Override
	public PlayerSkillResponse createSkillsPlayerCharacter(PlayersSkillsRequest skillsReq, String username) {
		Users user = usersRepository.findByUsername(username);
		Players player = playersRepository.findByUserCharacterAndPlayerMode(user, user);
		PlayersSkills skillsExisting = playerSkillRepository.findByPlayer(player);
		
		if(Objects.nonNull(skillsExisting)) {
			new RuntimeException("não é possivel adicionar mais de uma skill para o mesmo jogador");
		}
		
		PlayersSkills playerSkill = skillsReq.toEntity();
		player.setOverall(skillsReq.calculateOverall(playerSkill, player));
	
		playersRepository.save(player);
		playerSkillRepository.save(playerSkill);
		
		return PlayerSkillResponse.toDto(playerSkill);
	}
	
	@Override
	public PlayerSkillResponse updateSkillsPlayerCharacter(PlayersSkillsRequest skillsReq, String username) {
		Users user = usersRepository.findByUsername(username);
		Players player = playersRepository.findByUserCharacterAndPlayerMode(user, user);
		PlayersSkills playerSkill = playerSkillRepository.findByPlayer(player);
		
		if(Objects.isNull(playerSkill)) {
			new RuntimeException("nenhuma skill existente, crie uma skill para poder atualizar");
		}
		
		skillsReq.updateSkill(playerSkill);
		player.setOverall(skillsReq.calculateOverall(playerSkill, player));
		
		playersRepository.save(player);
		playerSkillRepository.save(playerSkill);
		
		return PlayerSkillResponse.toDto(playerSkill);
	}
	 
}