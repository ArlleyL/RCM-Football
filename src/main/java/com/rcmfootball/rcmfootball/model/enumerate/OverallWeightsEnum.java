package com.rcmfootball.rcmfootball.model.enumerate;

import java.util.Map;

public enum OverallWeightsEnum {
	GOALKEEPER(Map.of(
			"speed", 0.05, "tecnic",0.05, "pass", 0.10,
			"finish", 0.00, "fisic", 0.30, "mentality", 0.50
			)),
	LIBERO(Map.of(
			"speed", 0.10, "tecnic",0.15, "pass", 0.20,
			"finish", 0.05, "fisic", 0.25, "mentality", 0.25
			)),
	DEFENDER(Map.of(
			"speed", 0.10, "tecnic",0.10, "pass", 0.15,
			"finish", 0.05, "fisic", 0.35, "mentality", 0.25
			)),
	RIGHTBACK(Map.of(
			"speed", 0.20, "tecnic",0.15, "pass", 0.20,
			"finish", 0.05, "fisic", 0.20, "mentality", 0.20
			)),
	LEFTBACK(Map.of(
			"speed", 0.20, "tecnic",0.15, "pass", 0.20,
			"finish", 0.05, "fisic", 0.20, "mentality", 0.20
			)),
	DEFENSIVEMIDFIELDER(Map.of(
			"speed", 0.10, "tecnic",0.15, "pass", 0.25,
			"finish", 0.05, "fisic", 0.25, "mentality", 0.20
			)),
	MIDFIELDER(Map.of(
			"speed", 0.15, "tecnic",0.20, "pass", 0.25,
			"finish", 0.10, "fisic", 0.15, "mentality", 0.15
			)),
	ATACKINGMIDFIELDER(Map.of(
			"speed", 0.15, "tecnic",0.25, "pass", 0.25,
			"finish", 0.20, "fisic", 0.05, "mentality", 0.10
			)),
	LEFTMIDFIELDER(Map.of(
			"speed", 0.20, "tecnic",0.20, "pass", 0.25,
			"finish", 0.10, "fisic", 0.15, "mentality", 0.10
			)),
	RIGHTMIDFIELDER(Map.of(
			"speed", 0.20, "tecnic",0.20, "pass", 0.25,
			"finish", 0.10, "fisic", 0.15, "mentality", 0.10
			)),
	LEFTWINGER(Map.of(
			"speed", 0.25, "tecnic",0.20, "pass", 0.15,
			"finish", 0.20, "fisic", 0.05, "mentality", 0.10
			)),
	RIGHTWINGER(Map.of(
			"speed", 0.25, "tecnic",0.25, "pass", 0.15,
			"finish", 0.20, "fisic", 0.05, "mentality", 0.10
			)),
	SECONDSTRIKER(Map.of(
			"speed", 0.20, "tecnic",0.20, "pass", 0.15,
			"finish", 0.30, "fisic", 0.05, "mentality", 0.10
			)),
	CENTERFORWARD(Map.of(
			"speed", 0.25, "tecnic",0.20, "pass", 0.10,
			"finish", 0.30, "fisic", 0.10, "mentality", 0.05
			));
	
	private final Map<String, Double> weight;

	private OverallWeightsEnum(Map<String, Double> weight) {
		this.weight = weight;
	}
	
	public Map<String, Double> getWeights(){
		return weight;
	}
}
