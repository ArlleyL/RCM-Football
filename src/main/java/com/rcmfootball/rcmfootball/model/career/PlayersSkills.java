package com.rcmfootball.rcmfootball.model.career;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
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
	@Digits(integer=2, fraction=0, message="limite de digitos atingido. número máximo de digitos: 2")
	private Integer speed;
	@Digits(integer=2, fraction=0, message="limite de digitos atingido. número máximo de digitos: 2")
	private Integer tecnic;
	@Digits(integer=2, fraction=0, message="limite de digitos atingido. número máximo de digitos: 2")
	private Integer pass;
	@Digits(integer=2, fraction=0, message="limite de digitos atingido. número máximo de digitos: 2")
	private Integer finish;
	@Digits(integer=2, fraction=0, message="limite de digitos atingido. número máximo de digitos: 2")
	private Integer fisic;
	@Digits(integer=2, fraction=0, message="limite de digitos atingido. número máximo de digitos: 2")
	private Integer mentality;
	
	
	@ManyToOne
	@JoinColumn(name="id_player", nullable=false)
	private Players player;
}
