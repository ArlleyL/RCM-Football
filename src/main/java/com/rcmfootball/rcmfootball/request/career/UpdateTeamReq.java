package com.rcmfootball.rcmfootball.request.career;

import com.rcmfootball.rcmfootball.model.career.Teams;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class UpdateTeamReq {
	@Min(value=0, message="não é permitido números negativos")
	private Integer numberOfFans;
	@Max(value=999999, message="capacidade máxima")
	private Integer stadiumCapacity;
	
	public Teams toDto(Teams team) {
		if(numberOfFans != null) team.setNumberOfFans(numberOfFans);
		if(stadiumCapacity != null)team.setStadiumCapacity(stadiumCapacity);
		
		return team;
	}
}
