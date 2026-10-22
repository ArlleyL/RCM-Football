package com.rcmfootball.rcmfootball.request.career;

import com.rcmfootball.rcmfootball.model.career.Managers;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateManagersReq {
	private String urlPhoto;
	@Min(value=0, message="o valor não deve ser número negativo")
	@Max(value=100, message="valor acima do máximo permitido")
	private Integer fansReputation;
	@Min(value=0, message="o valor não deve ser número negativo")
	@Max(value=100, message="valor acima do máximo permitido")
	private Integer teamReputation;
	
	public Managers updatedManager(Managers manager) {
		if(urlPhoto != null) manager.setUrlPhoto(urlPhoto);
		if(fansReputation != null) manager.setFansReputation(fansReputation);
		if(teamReputation != null) manager.setTeamReputation(teamReputation);
		return manager;
	}
}
