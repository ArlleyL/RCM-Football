package com.rcmfootball.rcmfootball.model.career;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="players_skills")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayersSkills {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPlayerSkill;
	private Integer speed;
	private Integer tecnic;
	private Integer pass;
	private Integer finish;
	private Integer fisic;
	private Integer mentality;
	
	
	@ManyToOne
	@JoinColumn(name="id_player", nullable=false)
	private Players player;
}
