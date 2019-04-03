package com.nextoo.weather.entities;

import com.fasterxml.jackson.annotation.JsonSetter;

public class DonneesParHeure {
	@JsonSetter("APCPsfc")
    private Float precipitation;

	@JsonSetter("CONDITION")
	private String condition;
	
	public Float getPrecipitation() {
		return precipitation;
	}

	public void setPrecipitation(Float precipitation) {
		this.precipitation = precipitation;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	
}
