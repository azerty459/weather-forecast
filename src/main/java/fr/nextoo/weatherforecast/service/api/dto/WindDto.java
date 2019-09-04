package fr.nextoo.weatherforecast.service.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WindDto {

	@JsonProperty("speed")
	private double windSpeed;

	@JsonProperty("deg")
	private double windDegrees;

	public double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public double getWindDegrees() {
		return windDegrees;
	}

	public void setWindDegrees(double windDegrees) {
		this.windDegrees = windDegrees;
	}

	@Override
	public String toString() {
		return "WindDto [windSpeed=" + windSpeed + ", windDegrees=" + windDegrees + "]";
	}

}
