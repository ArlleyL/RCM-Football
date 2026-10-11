package com.rcmfootball.rcmfootball.request.career;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.rcmfootball.rcmfootball.model.career.Players;
import com.rcmfootball.rcmfootball.model.career.PlayersSkills;
import com.rcmfootball.rcmfootball.model.enumerate.OverallWeightsEnum;
import com.rcmfootball.rcmfootball.model.enumerate.PlayersPositions;
import com.rcmfootball.rcmfootball.model.enumerate.ProfissionEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlayersSkillsRequest {
	
	private Integer speed;
	private Integer tecnic;
	private Integer pass;
	private Integer finish;
	private Integer fisic;
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
