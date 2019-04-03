package com.projet.dto;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InfoHumidity {

	private int currentHumidity;

	private double averageHumidity;


	public InfoHumidity(int currentHumidity, double averageHumidity) {
		this.currentHumidity = currentHumidity;
		this.averageHumidity = averageHumidity;
	}

	@JsonProperty("current_humidity")
	public int getCurrentHumidity() {
		return currentHumidity;
	}

	public void setCurrentHumidity(int currentHumidity) {
		this.currentHumidity = currentHumidity;
	}

	@JsonProperty("average_humidity")
	public double getAverageHumidity() {
		return averageHumidity;
	}

	public void setAverageHumidity(int averageHumidity) {
		this.averageHumidity = averageHumidity;
	}


}
