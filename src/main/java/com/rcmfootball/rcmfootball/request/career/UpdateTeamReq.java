package com.rcmfootball.rcmfootball.request.career;

import com.rcmfootball.rcmfootball.model.career.Teams;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTeamReq {
	private String teamCrestUrl;
	@Size(min=4, max=30, message="o mínimo de caracteres é 4 e o máximo 30")
	private String nameStadium;
	@Min(value=0, message="não é permitido números negativos")
	private Integer numberOfFans;
	@Max(value=999999, message="capacidade máxima")
	private Integer stadiumCapacity;
	
	public Teams dtoToUpdateTeam(Teams team) {
		if(teamCrestUrl != null) team.setTeamCrestUrl(teamCrestUrl);
		if(nameStadium != null) team.setNameStadium(nameStadium);
		if(numberOfFans != null) team.setNumberOfFans(numberOfFans);
		if(stadiumCapacity != null)team.setStadiumCapacity(stadiumCapacity);
		
		return team;
	}
}
