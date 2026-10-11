package com.rcmfootball.rcmfootball.response.career;

import com.rcmfootball.rcmfootball.model.career.PlayersSkills;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerSkillResponse {
	private Long idPlayerSkill;
	private Integer speed;
	private Integer tecnic;
	private Integer pass;
	private Integer finish;
	private Integer fisic;
	private Integer mentality;
	
	public static PlayerSkillResponse toDto(PlayersSkills ps) {
		return new PlayerSkillResponse(
					ps.getIdPlayerSkill(),
					ps.getSpeed(),
					ps.getTecnic(),
					ps.getPass(),
					ps.getFinish(),
					ps.getFisic(),
					ps.getMentality()
				);
	}
}
