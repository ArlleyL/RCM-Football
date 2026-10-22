package com.rcmfootball.rcmfootball.model.career;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Finances {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFinance;
	@Column(nullable=false, precision=8, scale=2)
	private BigDecimal wage;
	@Column(precision=8, scale=2)
	private BigDecimal balance;
	@Column(precision=8, scale=2)
	private BigDecimal spendLimit;
	@Column(precision=8, scale=2)
	private BigDecimal seasonSped;
	
	@ManyToOne
	@JoinColumn(name="id_player")
	private Players player;
	@ManyToOne
	@JoinColumn(name="id_manager")
	private Managers manager;
}
