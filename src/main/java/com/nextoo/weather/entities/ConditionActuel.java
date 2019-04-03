package com.nextoo.weather.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConditionActuel {
	@JsonProperty("date")
	String date;
	
	@JsonProperty("hour")
	String heure;
	
	@JsonProperty("tmp")
	String temperature;
	
	@JsonProperty("condition")
	String condition;
	
	@JsonProperty("humidity")
	private double humidite;

	
	public ConditionActuel() {
		super();
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getHeure() {
		return heure;
	}


	public void setHeure(String heure) {
		this.heure = heure;
	}


	public String getTemperature() {
		return temperature;
	}


	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}


	public String getCondition() {
		return condition;
	}


	public void setCondition(String condition) {
		this.condition = condition;
	}


	public double getHumidite() {
		return humidite;
	}


	public void setHumidite(double humidite) {
		this.humidite = humidite;
	}

	
}
