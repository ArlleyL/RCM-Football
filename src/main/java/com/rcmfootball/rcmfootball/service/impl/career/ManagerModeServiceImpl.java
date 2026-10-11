package com.rcmfootball.rcmfootball.service.impl.career;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcmfootball.rcmfootball.model.career.Managers;
import com.rcmfootball.rcmfootball.model.career.Nationality;
import com.rcmfootball.rcmfootball.model.users.Users;
import com.rcmfootball.rcmfootball.repository.career.ManagersRepository;
import com.rcmfootball.rcmfootball.repository.career.NationsRepository;
import com.rcmfootball.rcmfootball.repository.users.UsersRepository;
import com.rcmfootball.rcmfootball.request.career.ManagersRequest;
import com.rcmfootball.rcmfootball.request.career.UpdateManagersReq;
import com.rcmfootball.rcmfootball.response.career.ManagersResponse;
import com.rcmfootball.rcmfootball.service.career.ManagerModeService;

@Service
public class ManagerModeServiceImpl implements ManagerModeService{
	@Autowired
	private ManagersRepository managersRepository;
	@Autowired
	private NationsRepository nationsRepository;
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public ManagersResponse createManagerCharacter(ManagersRequest managerReq, String username) {
		Users user = usersRepository.findByUsername(username);
		Managers managerExisting = managersRepository.findByManagerCharacterAndManagerMode(user, user);
		
		if(Objects.nonNull(managerExisting)) {
			throw new RuntimeException("Não é possivel criar outro manager personagem");
		}
		
		Managers manager = managerReq.toEntity();
		Nationality nation = nationsRepository.findByCod(managerReq.getNation());
		manager.setNation(nation);
		manager.setManagerMode(user);
		
		managersRepository.save(manager);
		
		return ManagersResponse.toDto(manager);
	}
	
	@Override
	public ManagersResponse updateManagerCharacter(UpdateManagersReq managerReq, String username) {
		Users user = usersRepository.findByUsername(username);
		Managers managerExisting = managersRepository.findByManagerCharacterAndManagerMode(user, user);
		
		Managers manager = managerReq.updatedManager(managerExisting);
		
		managersRepository.save(manager);
		
		return ManagersResponse.toDto(manager);
	}
	
	@Override
	public ManagersResponse createManager(ManagersRequest managerReq, String username) {
		Users user = usersRepository.findByUsername(username);
		Managers managerExisting = managersRepository.findByManagerModeAndProfission(user, managerReq.getProfission());
		
		if(Objects.nonNull(managerExisting)) {
			new RuntimeException("Contém outro manager com a profissão "+ managerReq.getProfission());
		}
		
		Managers manager = managerReq.toEntity();
		Nationality nation = nationsRepository.findByCod(managerReq.getNation());
		manager.setNation(nation);
		manager.setPlayerMode(user);
		
		managersRepository.save(manager);
		
		return ManagersResponse.toDto(manager);
	}
	
	@Override
	public ManagersResponse updateManager(UpdateManagersReq managerReq, Long id) {
		Managers managerExisting = managersRepository.findById(id).orElseThrow(()->new RuntimeException("Manager não encontrado com id: "+id));
		
		if(managerExisting.getManagerCharacter() != null) {
			throw new RuntimeException("Não foi possivel atualizar o jogador");
		}
		
		Managers manager = managerReq.updatedManager(managerExisting);
		
		managersRepository.save(manager);
		
		return ManagersResponse.toDto(manager);
	}
	
	@Override
	public ManagersResponse createManagerPlayerMode(ManagersRequest managerReq, String username) {
		Users user = usersRepository.findByUsername(username);
		Managers managerExisting = managersRepository.findByPlayerModeAndProfission(user, managerReq.getProfission());
		
		if(Objects.nonNull(managerExisting)) {
			new RuntimeException("Contém outro manager com a profissão "+ managerReq.getProfission());
		}
		
		Managers manager = managerReq.toEntity();
		Nationality nation = nationsRepository.findByCod(managerReq.getNation());
		manager.setNation(nation);
		manager.setManagerCharacter(user);
		manager.setManagerMode(user);
		
		managersRepository.save(manager);
		
		return ManagersResponse.toDto(manager);
	}
	
	@Override
	public ManagersResponse updateManagerPlayerMode(UpdateManagersReq managerReq, Long id) {
		Managers managerExisting = managersRepository.findById(id).orElseThrow(()->new RuntimeException("Manager não encontrado com id: "+id));
		
		if(managerExisting.getManagerCharacter() != null) {
			throw new RuntimeException("Não foi possivel atualizar o jogador");
		}
		
		Managers manager = managerReq.updatedManager(managerExisting);
		
		managersRepository.save(manager);
		
		return ManagersResponse.toDto(manager);
	}
	
	
	
}
