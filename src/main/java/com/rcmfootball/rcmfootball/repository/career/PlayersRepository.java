package com.rcmfootball.rcmfootball.repository.career;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rcmfootball.rcmfootball.model.career.Players;
import com.rcmfootball.rcmfootball.model.users.Users;

@Repository
public interface PlayersRepository extends JpaRepository<Players, Long>{
	
	Players findByIdPlayerAndPlayerMode(Long idPlayer, Users playerMode);
	
	Players findByUserCharacterAndPlayerMode(Users userCharacter, Users playerMode);

	List<Players> findByPlayerMode(Users user);

	List<Players> findByManagerMode(Users user);
}
