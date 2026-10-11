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
@Table(name="history_transfer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transfer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTransfer;
	@Column(nullable=false)
	@Digits(integer=9, fraction=2, message="número de caracteres atingido")
	@PositiveOrZero(message="o valor deve ser acima de 0")
	private BigDecimal totalValue;
	@Column(nullable=false)
	@Digits(integer=6, fraction=2, message="número de caracteres atingido")
	@PositiveOrZero(message="o valor deve ser acima de 0")
	private BigDecimal wage;
	@Min(0)
	@Max(5)
	private Integer year;
	@PositiveOrZero(message="O valor deve ser acima de 0")
	private Integer month;
	private Boolean isAccepted;
	@Column(nullable=false)
	private Boolean renovation;
	@Column(nullable=false)
	private Boolean offerActive;
	
	@ManyToOne
	@JoinColumn(name="id_old_team")
	private Teams oldTeam;
	
	@ManyToOne
	@JoinColumn(name="id_new_team", nullable=false)
	private Teams newTeam;
	
	@ManyToOne
	@JoinColumn(name="id_player")
	private Players player;
	
	@ManyToOne
	@JoinColumn(name="id_manager")
	private Managers manager;
}
