package com.rcmfootball.rcmfootball.request.career;

import java.util.Map;

import com.rcmfootball.rcmfootball.model.career.Players;
import com.rcmfootball.rcmfootball.model.career.PlayersSkills;
import com.rcmfootball.rcmfootball.model.enumerate.OverallWeightsEnum;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlayersSkillsRequest {
	
	@Digits(integer=2, fraction=0, message="limite de digitos atingido. número máximo de digitos: 2")
	@Max(value=99, message="o limite máximo é 99")
	@Min(value=10, message="o limite minimo é 10")
	private Integer speed;
	@Digits(integer=2, fraction=0, message="limite de digitos atingido. número máximo de digitos: 2")
	@Max(value=99, message="o limite máximo é 99")
	@Min(value=10, message="o limite minimo é 10")
	private Integer tecnic;
	@Digits(integer=2, fraction=0, message="limite de digitos atingido. número máximo de digitos: 2")
	@Max(value=99, message="o limite máximo é 99")
	@Min(value=10, message="o limite minimo é 10")
	private Integer pass;
	@Digits(integer=2, fraction=0, message="limite de digitos atingido. número máximo de digitos: 2")
	@Max(value=99, message="o limite máximo é 99")
	@Min(value=10, message="o limite minimo é 10")
	private Integer finish;
	@Digits(integer=2, fraction=0, message="limite de digitos atingido. número máximo de digitos: 2")
	@Max(value=99, message="o limite máximo é 99")
	@Min(value=10, message="o limite minimo é 10")
	private Integer fisic;
	@Digits(integer=2, fraction=0, message="limite de digitos atingido. número máximo de digitos: 2")
	@Max(value=99, message="o limite máximo é 99")
	@Min(value=10, message="o limite minimo é 10")
	private Integer mentality;
	
	public PlayersSkills toEntity() {
		PlayersSkills playerSkill = new PlayersSkills();
		playerSkill.setSpeed(speed);
		playerSkill.setTecnic(tecnic);
		playerSkill.setPass(pass);
		playerSkill.setFinish(finish);
		playerSkill.setFisic(fisic);
		playerSkill.setMentality(mentality);
		
		return playerSkill;
	}
	
	public PlayersSkills updateSkill(PlayersSkills playerSkill) {
		if(speed != null) playerSkill.setSpeed(speed);
		if(tecnic != null) playerSkill.setTecnic(tecnic);
		if(pass != null) playerSkill.setPass(pass);
		if(finish != null) playerSkill.setFinish(finish);
		if(fisic != null) playerSkill.setMentality(mentality);
		
		return playerSkill;
	}
	
	public Integer calculateOverall(PlayersSkills skills, Players player){
		Map<String, Double> weights = OverallWeightsEnum.valueOf(player.getPosition().toString()).getWeights();
		double overall = 
				skills.getSpeed() * weights.get("speed") +
				skills.getTecnic() * weights.get("tecnic") +
				skills.getPass() * weights.get("pass") +
				skills.getFinish() * weights.get("finish") +
				skills.getFisic() * weights.get("fisic") +
				skills.getMentality() * weights.get("mentality");
		
		return (int) Math.round(overall);
	}
	
	
	
}
