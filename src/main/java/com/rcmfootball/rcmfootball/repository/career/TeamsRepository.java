package com.rcmfootball.rcmfootball.repository.career;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rcmfootball.rcmfootball.model.career.Teams;
import com.rcmfootball.rcmfootball.model.users.Users;
import java.util.List;

@Repository
public interface TeamsRepository extends JpaRepository<Teams, Long>{

	Teams findByIdTeamAndPlayerMode(Long id, Users user);

	Teams findByIdTeamAndManagerMode(Long id, Users user);

	List<Teams> findByPlayerMode(Users user);

	List<Teams> findByManagerMode(Users user);


}
