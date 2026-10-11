package com.rcmfootball.rcmfootball.model.career;

import java.math.BigDecimal;

import com.rcmfootball.rcmfootball.model.enumerate.BestFootEnum;
import com.rcmfootball.rcmfootball.model.enumerate.PlayersPositions;
import com.rcmfootball.rcmfootball.model.users.Users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="players")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Players {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPlayer;
	private String photo;
	@Column(nullable=false, length=30)
	private String name;
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private PlayersPositions position;
	@Digits(integer=2, fraction=0)
	@Column(nullable=false)
	private Integer shirtNumber;
	@Digits(integer=2, fraction=0)
	@Column(nullable=false)
	private Integer ageOfPlayer;
	private Boolean playsForNationTeam;
	@Digits(integer=1, fraction=2, message="formatação invalida para altura. Formatação correta: x.xx")
	@Column(precision=3, scale=2)
	private BigDecimal height;
	@Digits(integer=3, fraction=1, message="formatação invalida para peso, Formatação correta: xx.x")
	@Column(precision=4, scale=1)
	private BigDecimal weight;
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private BestFootEnum bestFoot;
	@Digits(integer=2, fraction=0, message="o overall deve ter no máximo 2 caracteres")
	private Integer overall;
	
	@ManyToOne
	@JoinColumn(name="id_user_player_mode")
	private Users playerMode;
	@ManyToOne
	@JoinColumn(name="id_user_menager_mode")
	private Users managerMode;
	@ManyToOne
	@JoinColumn(name="id_user_character")
	private Users userCharacter;
	@ManyToOne
	@JoinColumn(name="nation_code", nullable=false)
	private Nationality nation;
	@ManyToOne
	@JoinColumn(name="id_current_team")
	private Teams currentTeam;
}