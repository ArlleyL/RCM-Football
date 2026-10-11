package com.rcmfootball.rcmfootball.request.career;

import java.math.BigDecimal;

import com.rcmfootball.rcmfootball.model.career.Nationality;
import com.rcmfootball.rcmfootball.model.career.Players;
import com.rcmfootball.rcmfootball.model.enumerate.BestFootEnum;
import com.rcmfootball.rcmfootball.model.enumerate.PlayersPositions;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlayersRequest{
	private String urlPhoto;
	@NotBlank(message="o nome do jogador é obrigatório")
	@Size(min=4, max=30, message="o mínimo de caracteres é 4 e o máximo 30")
	private String name;
	@NotNull(message="defina a posição do jogador")
	private PlayersPositions position;
	@NotNull(message="coloque o número da camisa")
	@Max(value=99, message="o número da camisa deve ser de 1 a 99")
	@Min(value=1, message="o número da camisa deve ser de 1 a 99")
	private Integer shirtNumber;
	@NotNull(message="a idade do jogador é obrigatória")
	@Max(value=50, message="a idade máxima é de 50 anos")
	@Min(value=15, message="a idade mínima é de 15 anos")
	private Integer age;
	private Boolean playsForNationTeam;
	private BigDecimal height;
	private BigDecimal weight;
	@NotNull(message="o pé dominante é obrigatório")
	private BestFootEnum bestFoot;
	@NotBlank(message="O país é obrigatório")
	@Size(min=3, max=3)
	private String nation;
	
	public Players toEntity() {
		Players player = new Players();
		player.setPhoto(urlPhoto);
		player.setName(name);
		player.setPosition(position);
		player.setShirtNumber(shirtNumber);
		player.setAgeOfPlayer(age);
		player.setPlaysForNationTeam(playsForNationTeam);
		player.setHeight(height);
		player.setWeight(weight);
		player.setBestFoot(bestFoot);
		return player;
	}
		
}
