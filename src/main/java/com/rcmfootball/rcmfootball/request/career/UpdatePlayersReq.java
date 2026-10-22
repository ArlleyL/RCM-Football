package com.rcmfootball.rcmfootball.request.career;

import java.math.BigDecimal;

import com.rcmfootball.rcmfootball.model.career.Players;
import com.rcmfootball.rcmfootball.model.enumerate.PlayersPositions;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePlayersReq {
	private String urlPhoto;
	private PlayersPositions position;
	@Max(value=99, message="o número da camisa deve ser de 1 a 99")
	@Min(value=1, message="o número da camisa deve ser de 1 a 99")
	@Digits(integer=2, fraction=0, message="numero da camisa invalida")
	private Integer shirtNumber;
	private Boolean playsForNationTeam;
	@Digits(integer=3, fraction=1, message="formatação invalida para peso, Formatação correta: xx.x")
	private BigDecimal weight;
	
	public Players updatedPlayer(Players player) {
		if(urlPhoto != null) player.setPhoto(urlPhoto);
		if(position != null) player.setPosition(position);
		if(shirtNumber != null) player.setShirtNumber(shirtNumber);
		if(playsForNationTeam != null) player.setPlaysForNationTeam(playsForNationTeam);
		if(weight != null) player.setWeight(weight);
		
		return player;
	}
}
