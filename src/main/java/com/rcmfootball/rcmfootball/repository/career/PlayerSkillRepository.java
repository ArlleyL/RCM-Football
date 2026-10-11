package com.rcmfootball.rcmfootball.repository.career;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rcmfootball.rcmfootball.model.career.Players;
import com.rcmfootball.rcmfootball.model.career.PlayersSkills;

@Repository
public interface PlayerSkillRepository extends JpaRepository<PlayersSkills, Long>{

	PlayersSkills findByPlayer(Players player);

}
