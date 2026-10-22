package com.rcmfootball.rcmfootball.response.career;

import com.rcmfootball.rcmfootball.model.career.Managers;
import com.rcmfootball.rcmfootball.model.career.Nationality;
import com.rcmfootball.rcmfootball.model.career.Teams;
import com.rcmfootball.rcmfootball.model.enumerate.ProfissionEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ManagersResponse {
	private Long idManager;
	private String urlPhoto;
	private String name;
	private ProfissionEnum profission;
	private Nationality nation;
	private Teams currentTeam;
	private Integer fansReputation;
	private Integer teamReputation;
	
	public static ManagersResponse toDto(Managers m) {
		return new ManagersResponse(
				m.getIdManager(),
				m.getUrlPhoto(),
				m.getName(),
				m.getProfission(),
				m.getNation(),
				m.getCurrentTeam(),
				m.getFansReputation(),
				m.getTeamReputation()
				);
	}
}
