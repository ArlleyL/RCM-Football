package com.rcmfootball.rcmfootball.service.career;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.rcmfootball.rcmfootball.request.career.PlayersRequest;
import com.rcmfootball.rcmfootball.request.career.PlayersSkillsRequest;
import com.rcmfootball.rcmfootball.request.career.UpdatePlayersReq;
import com.rcmfootball.rcmfootball.response.career.PlayerSkillResponse;
import com.rcmfootball.rcmfootball.response.career.PlayersResponse;

public interface PlayersService {

	PlayersResponse playerCharacterProfile(String username);
	PlayersResponse savePlayerOfUser(PlayersRequest playerReq, String username);
	PlayersResponse updatePlayerOfUser(UpdatePlayersReq playerReq, String username);
	ResponseEntity<Void> deletePlayerCharacter(Long id, String username);

	List<PlayersResponse> allPlayersOfPlayerMode(String username);
	PlayersResponse savePlayerTeammate(PlayersRequest playerReq);
	PlayersResponse updatePlayerTeammate(UpdatePlayersReq playerReq, Long id);
	ResponseEntity<Void> deletePlayerTeammate(Long id, String username);
	
	PlayerSkillResponse findSkillByPlayerCharacter(String username);
	PlayerSkillResponse createSkillsPlayerCharacter(PlayersSkillsRequest skillsReq, String username);
	PlayerSkillResponse updateSkillsPlayerCharacter(PlayersSkillsRequest skillsReq, String username);

	
}
