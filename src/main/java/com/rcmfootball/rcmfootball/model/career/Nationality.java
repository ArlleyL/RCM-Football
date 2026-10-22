package com.rcmfootball.rcmfootball.model.career;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="nationality")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Nationality {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idNationality;
	@Column(nullable=true)
	private String flag;
	@Column(nullable=false, length=40)
	private String name;
	@Column(length=3)
	private String cod;
}
