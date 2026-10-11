package com.rcmfootball.rcmfootball.model.career;

import com.rcmfootball.rcmfootball.model.users.Users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name="teams")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teams {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTeam;
	private String teamCrestUrl;
	@Column(nullable=false, length=40)
	private String name;
	@Column(nullable=false, length=3)
	private String abbreviatedName;
	private Integer numberOfFans;
	@Column(nullable=false, length=30)
	private String nameStadium;
	@Column(length=30)
	private Integer stadiumCapacity;
	
	@ManyToOne
	@JoinColumn(name="nationality_id", nullable=false)
	private Nationality nation;
	@ManyToOne
	@JoinColumn(name="id_user_player_mode")
	private Users playerMode;
	@ManyToOne
	@JoinColumn(name="id_user_manager_mode")
	private Users managerMode;
}
