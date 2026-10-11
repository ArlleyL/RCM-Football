package com.rcmfootball.rcmfootball.response.career;

import java.math.BigDecimal;

import com.rcmfootball.rcmfootball.model.career.Nationality;
import com.rcmfootball.rcmfootball.model.career.Players;
import com.rcmfootball.rcmfootball.model.career.Teams;
import com.rcmfootball.rcmfootball.model.enumerate.BestFootEnum;
import com.rcmfootball.rcmfootball.model.enumerate.PlayersPositions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlayersResponse {
	private Long id;
	private String urlPhoto;
	private String name;
	private PlayersPositions position;
	private Integer shirtNumber;
	private Integer age;
	private Boolean playsForNationTeam;
	private BigDecimal height;
	private BigDecimal weight;
	private BestFootEnum bestFoot;
	private Nationality nation;
	private Teams currentTeam;
	
	public static PlayersResponse toDto(Players p) {
		return new PlayersResponse(
				p.getIdPlayer(),
				p.getPhoto(),
				p.getName(),
				p.getPosition(),
				p.getShirtNumber(),
				p.getAgeOfPlayer(),
				p.getPlaysForNationTeam(),
				p.getHeight(),
				p.getWeight(),
				p.getBestFoot(),
				p.getNation(),
				p.getCurrentTeam()
			);
	}
}
