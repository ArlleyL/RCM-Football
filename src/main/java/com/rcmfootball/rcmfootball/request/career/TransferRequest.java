package com.rcmfootball.rcmfootball.request.career;

import java.math.BigDecimal;

import org.apache.catalina.Manager;

import com.rcmfootball.rcmfootball.model.career.Players;
import com.rcmfootball.rcmfootball.model.career.Teams;
import com.rcmfootball.rcmfootball.model.career.Transfer;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TransferRequest {
	private BigDecimal totalValue;
	private BigDecimal wage;
	private Integer year;
	private Integer month;
	private Boolean isAccepted;
	private Boolean renovation;
	private Boolean offerActive;
	
	public Transfer toEntity() {
		Transfer transfer = new Transfer();
		transfer.setTotalValue(totalValue);
		transfer.setWage(wage);
		transfer.setYear(year);
		transfer.setMonth(month);
		transfer.setIsAccepted(isAccepted);
		transfer.setRenovation(renovation);
		transfer.setOfferActive(offerActive);
		
		return transfer;
	}
	
	public Transfer updateTransferDetailsPlayer(Transfer transfer) {
		if(totalValue != null) transfer.setTotalValue(totalValue);
		if(wage != null) transfer.setWage(wage);
		if(year != null) transfer.setMonth(month);
		if(isAccepted != null) transfer.setIsAccepted(isAccepted);
		if(renovation != null) transfer.setRenovation(renovation);
		if(offerActive != null) transfer.setOfferActive(offerActive);
		
		return transfer;
	}
}
