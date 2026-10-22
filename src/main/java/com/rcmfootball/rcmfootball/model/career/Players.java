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
	@Column(nullable=false, precision=2)
	private Integer shirtNumber;
	@Column(nullable=false, precision=2)
	private Integer ageOfPlayer;
	private Boolean playsForNationTeam;
	@Column(precision=3, scale=2)
	private BigDecimal height;
	@Column(precision=4, scale=1)
	private BigDecimal weight;
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private BestFootEnum bestFoot;
	@Column(precision=2)
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