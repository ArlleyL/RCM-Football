package com.rcmfootball.rcmfootball.service.impl.career;

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

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamsServiceImpl implements TeamsService{
	@Autowired
	private TeamsRepository teamsRepository;
	@Autowired
	private NationsRepository nationsRepository;
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public List<TeamsResponse> findAllTeamPlayerMode(String username){
		Users user = usersRepository.findByUsername(username);
		List<Teams> team = teamsRepository.findByPlayerMode(user);
		return team.stream().map(TeamsResponse::toDto).collect(Collectors.toList());
	}
	
	@Override
	public TeamsResponse createTeamPlayerMode(TeamsRequest teamReq, String username) {
		Users user = usersRepository.findByUsername(username);
		List<Teams> teamExistent = teamsRepository.findByPlayerMode(user);
		
		for(Teams team : teamExistent) {
			if(teamReq.getName().equalsIgnoreCase(team.getName())) {
				throw new RuntimeException("Há outro time com o nome '"+teamReq.getName()+"'");
			}
			if(teamReq.getAbbreviatedName().equalsIgnoreCase(team.getAbbreviatedName())) {
				throw new RuntimeException("Há outro time com a abreviação '"+teamReq.getAbbreviatedName()+"'");
			}
		}
		if(teamExistent.size() == 30) {
			throw new RuntimeException("Limite atingido de criação de times");
		}
		
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

		teamReq.dtoToUpdateTeam(team);
		
		teamsRepository.save(team);
		
		return TeamsResponse.toDto(team);
	}
	
	@Override
	public List<TeamsResponse> findAllTeamManagerMode(String username){
		Users user = usersRepository.findByUsername(username);
		List<Teams> team = teamsRepository.findByManagerMode(user);
		return team.stream().map(TeamsResponse::toDto).collect(Collectors.toList());
	}
	
	@Override
	public TeamsResponse createTeamManagerMode(TeamsRequest teamReq, String username) {
		Users user = usersRepository.findByUsername(username);
		List<Teams> teamExistent = teamsRepository.findByManagerMode(user);
		
		for(Teams team : teamExistent) {
			if(teamReq.getName().equalsIgnoreCase(team.getName())) throw new RuntimeException("Há outro time com o nome '"+teamReq.getName()+"'");
			if(teamReq.getAbbreviatedName().equalsIgnoreCase(team.getAbbreviatedName())) throw new RuntimeException("Há outro time com a abreviação '"+teamReq.getAbbreviatedName()+"'");
		}
		if(teamExistent.size() == 30) {
			throw new RuntimeException("Limite atingido de criação de times");
		}
		
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

		teamReq.dtoToUpdateTeam(team);
		
		teamsRepository.save(team);
		
		return TeamsResponse.toDto(team);
	}
	
}

