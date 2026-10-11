package com.rcmfootball.rcmfootball.repository.career;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rcmfootball.rcmfootball.model.career.Players;
import com.rcmfootball.rcmfootball.model.career.Transfer;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long>{
	Transfer findByIdTransferAndPlayer(Long id, Players player);
}
