package com.rcmfootball.rcmfootball.request.career;

import com.rcmfootball.rcmfootball.model.career.Managers;
import com.rcmfootball.rcmfootball.model.enumerate.ProfissionEnum;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ManagersRequest {
	private String urlPhoto;
	@NotBlank(message="o nome não deve ser nulo")
	@Size(min=4, max=30)
	private String name;
	private ProfissionEnum profission;
	@NotBlank(message="o país é obrigatório")
	@Size(min=3, max=3)
	private String nation;
	@Min(value=0, message="o valor não deve ser número negativo")
	@Max(value=99, message="valor acima do máximo permitido")
	private Integer fansReputation;
	@Min(value=0, message="o valor não deve ser número negativo")
	@Max(value=99, message="valor acima do máximo permitido")
	private Integer teamReputation;
	
	public Managers toEntity() {
		Managers manager = new Managers();
		manager.setUrlPhoto(urlPhoto);
		manager.setName(name);
		manager.setProfission(profission);
		manager.setFansReputation(fansReputation);
		manager.setTeamReputation(teamReputation);
		
		return manager;
	}
}
