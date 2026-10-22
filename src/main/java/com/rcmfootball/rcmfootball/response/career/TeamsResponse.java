package com.rcmfootball.rcmfootball.response.career;

import com.rcmfootball.rcmfootball.model.career.Nationality;
import com.rcmfootball.rcmfootball.model.career.Teams;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TeamsResponse {
	private Long idTeam;
	private String teamCrestUrl;
	private String name;
	private String abbreviatedName;
	private Integer numberOfFans;
	private String nameStadium;
	private Integer stadiumCapacity;
	private Nationality nation;
	
	public static TeamsResponse toDto(Teams t) {
		return new TeamsResponse(
				t.getIdTeam(),
				t.getTeamCrestUrl(),
				t.getName(),
				t.getAbbreviatedName(),
				t.getNumberOfFans(),
				t.getNameStadium(),
				t.getStadiumCapacity(),
				t.getNation()
				);
	}
}
