package com.rcmfootball.rcmfootball.repository.career;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rcmfootball.rcmfootball.model.career.Nationality;

@Repository
public interface NationsRepository extends JpaRepository<Nationality, Long>{
	Nationality findByCod(String cod);
}
