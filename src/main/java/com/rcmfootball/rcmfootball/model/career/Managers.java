package com.rcmfootball.rcmfootball.model.career;

import com.rcmfootball.rcmfootball.model.enumerate.ProfissionEnum;
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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="managers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Managers {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idManager;
	private String urlPhoto;
	@Column(nullable=false, length=30)
	private String name;
	@Enumerated(EnumType.STRING)
	private ProfissionEnum profission;
	@ManyToOne
	@JoinColumn(name="id_nation", nullable=false)
	private Nationality nation;
	@ManyToOne
	@JoinColumn(name="id_current_team")
	private Teams currentTeam;
	@Min(0)
	@Max(100)
	private Integer fansReputation;
	@Min(0)
	@Max(100)
	private Integer teamReputation;
	
	@ManyToOne
	@JoinColumn(name="id_user_player_mode")
	private Users playerMode;
	@ManyToOne
	@JoinColumn(name="id_user_menager_mode")
	private Users managerMode;
	@ManyToOne
	@JoinColumn(name="id_user_character")
	private Users managerCharacter;
}
