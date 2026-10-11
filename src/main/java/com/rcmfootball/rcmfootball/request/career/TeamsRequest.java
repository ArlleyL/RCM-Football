package com.rcmfootball.rcmfootball.request.career;

import com.rcmfootball.rcmfootball.model.career.Teams;

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
public class TeamsRequest {
	@NotBlank(message="o nome do time é obrigatório")
	@Size(min=4, max=30, message="o mínimo de caracteres é 4 e o máximo 30")
	private String name;
	@NotBlank
	@Size(min=3, max=3, message="o número de caracteres dever exatamente 3")
	private String abbreviatedName;
	@Min(value=0, message="não é permitido números negativos")
	private Integer numberOfFans;
	@Size(min=4, max=30, message="o mínimo de caracteres é 4 e o máximo 30")
	private String nameStadium;
	@Max(value=999999, message="capacidade máxima")
	private Integer stadiumCapacity;
	@Size(min=3, max=3)
	private String nation;
	
	public Teams toEntity() {
		Teams team = new Teams();
		team.setName(name);
		team.setAbbreviatedName(abbreviatedName);
		team.setNumberOfFans(numberOfFans);
		team.setNameStadium(nameStadium);
		team.setStadiumCapacity(stadiumCapacity);
		
		return team;
	}
}
