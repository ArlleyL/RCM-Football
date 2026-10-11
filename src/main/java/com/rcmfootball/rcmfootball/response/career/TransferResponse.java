package com.rcmfootball.rcmfootball.response.career;

import java.math.BigDecimal;

import org.apache.catalina.Manager;

import com.rcmfootball.rcmfootball.model.career.Players;
import com.rcmfootball.rcmfootball.model.career.Teams;
import com.rcmfootball.rcmfootball.model.career.Transfer;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TransferResponse {
	private Long idTransfer;
	private BigDecimal totalValue;
	private BigDecimal wage;
	private Integer year;
	private Integer month;
	private Boolean isAccepted;
	private Boolean renovation;
	private Boolean offerActive;
	private Teams newTeam;
	
	public static TransferResponse toDto(Transfer t) {
		return new TransferResponse(
				t.getIdTransfer(),
				t.getTotalValue(),
				t.getWage(),
				t.getYear(),
				t.getMonth(),
				t.getIsAccepted(),
				t.getRenovation(),
				t.getOfferActive(),
				t.getNewTeam()
				);
	}
}
