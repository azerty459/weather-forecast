package com.nextoo.weather.entities;

import java.util.HashMap;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Prevision {
	@JsonProperty("date")
	private String date;
	
	@JsonProperty("day_long")
	private String jour;
	
	@JsonProperty("tmin")
	private int temperatureMinimale;
	
	@JsonProperty("tmax")
	private int temperatureMaximale;
	
	@JsonProperty("condition")
	private String condition;
	
	@JsonProperty("hourly_data")
	//HashMap<String, DonneesParHeure> donneesParHeure;
	private DonneesParHeureListe donneesParHeure;
	
	public Prevision() {
		super();
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public int getTemperatureMinimale() {
		return temperatureMinimale;
	}

	public void setTemperatureMinimale(int temperatureMinimale) {
		this.temperatureMinimale = temperatureMinimale;
	}

	public int getTemperatureMaximale() {
		return temperatureMaximale;
	}

	public void setTemperatureMaximale(int temperatureMaximale) {
		this.temperatureMaximale = temperatureMaximale;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public DonneesParHeureListe getDonneesParHeure() {
		return donneesParHeure;
	}

	public void setDonneesParHeure(DonneesParHeureListe donneesParHeure) {
		this.donneesParHeure = donneesParHeure;
	}	
	
	
}
