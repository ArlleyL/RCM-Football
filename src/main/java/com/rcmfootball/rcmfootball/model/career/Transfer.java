package com.rcmfootball.rcmfootball.model.career;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="transfers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transfer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTransfer;
	@Column(nullable=false, precision=11, scale=2)
	private BigDecimal totalValue;
	@Column(nullable=false, precision=8, scale=2)
	private BigDecimal wage;
	@Column(precision=1)
	private Integer year;
	@Column(precision=1)
	private Integer month;
	private Boolean isAccepted;
	@Column(nullable=false)
	private Boolean renovation;
	@Column(nullable=false)
	private Boolean offerActive = true;
	
	@ManyToOne
	@JoinColumn(name="id_current_team")
	private Teams currentTeam;
	
	@ManyToOne
	@JoinColumn(name="id_new_team")
	private Teams newTeam;
	
	@ManyToOne
	@JoinColumn(name="id_player")
	private Players player;
	
	@ManyToOne
	@JoinColumn(name="id_manager")
	private Managers manager;
}
