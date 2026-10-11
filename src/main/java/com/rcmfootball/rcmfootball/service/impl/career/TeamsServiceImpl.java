package com.rcmfootball.rcmfootball.service.impl.career;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcmfootball.rcmfootball.model.career.Nationality;
import com.rcmfootball.rcmfootball.model.career.Teams;
import com.rcmfootball.rcmfootball.model.users.Users;
import com.rcmfootball.rcmfootball.repository.career.NationsRepository;
import com.rcmfootball.rcmfootball.repository.career.TeamsRepository;
import com.rcmfootball.rcmfootball.repository.users.UsersRepository;
import com.rcmfootball.rcmfootball.request.career.TeamsRequest;
import com.rcmfootball.rcmfootball.request.career.UpdateTeamReq;
import com.rcmfootball.rcmfootball.response.career.TeamsResponse;
import com.rcmfootball.rcmfootball.service.career.TeamsService;

@Service
public class TeamsServiceImpl implements TeamsService{
	@Autowired
	private TeamsRepository teamsRepository;
	@Autowired
	private NationsRepository nationsRepository;
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public TeamsResponse createTeamPlayerMode(TeamsRequest teamReq, String username) {
		Users user = usersRepository.findByUsername(username);
		
		Teams team = teamReq.toEntity();
		Nationality nation = nationsRepository.findByCod(teamReq.getNation());
		team.setNation(nation);
		team.setPlayerMode(user);
		
		teamsRepository.save(team);
		
		return TeamsResponse.toDto(team);
	}
	
	@Override
	public TeamsResponse updateTeamPlayerMode(UpdateTeamReq teamReq, String username, Long id) {
		Users user = usersRepository.findByUsername(username);
		Teams team = teamsRepository.findByIdTeamAndPlayerMode(id, user);
		
		if(Objects.isNull(team)) {
			new RuntimeException("Não encotrado nenhum registro com o id: "+ id);
		}
		
		teamsRepository.save(team);
		
		return TeamsResponse.toDto(team);
	}
	
	@Override
	public TeamsResponse createTeamManagerMode(TeamsRequest teamReq, String username) {
		Users user = usersRepository.findByUsername(username);
		
		Teams team = teamReq.toEntity();
		Nationality nation = nationsRepository.findByCod(teamReq.getNation());
		team.setNation(nation);
		team.setManagerMode(user);
		
		teamsRepository.save(team);
		
		return TeamsResponse.toDto(team);
	}
	
	@Override
	public TeamsResponse updateTeamManagerMode(UpdateTeamReq teamReq, String username, Long id) {
		Users user = usersRepository.findByUsername(username);
		Teams team = teamsRepository.findByIdTeamAndManagerMode(id, user);
		
		if(Objects.isNull(team)) {
			new RuntimeException("Não encotrado nenhum registro com o id: "+ id);
		}
		
		teamsRepository.save(team);
		
		return TeamsResponse.toDto(team);
	}
	
}

