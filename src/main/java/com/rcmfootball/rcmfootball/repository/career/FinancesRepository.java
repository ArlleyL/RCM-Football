package com.rcmfootball.rcmfootball.repository.career;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rcmfootball.rcmfootball.model.career.Finances;
import com.rcmfootball.rcmfootball.model.career.Players;

@Repository
public interface FinancesRepository extends JpaRepository<Finances, Long>{

	Finances findByPlayer(Players player);
	
}
