package com.rcmfootball.rcmfootball.repository.career;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rcmfootball.rcmfootball.model.career.Managers;
import com.rcmfootball.rcmfootball.model.enumerate.ProfissionEnum;
import com.rcmfootball.rcmfootball.model.users.Users;

@Repository
public interface ManagersRepository extends JpaRepository<Managers, Long>{

	Managers findByManagerCharacterAndManagerMode(Users managerCharacter, Users managerMode);

	Managers findByManagerModeAndProfission(Users user, ProfissionEnum profission);

	Managers findByPlayerModeAndProfission(Users user, ProfissionEnum profission);

	List<Managers> findByManagerMode(Users user);

	List<Managers> findByPlayerMode(Users user);

}
