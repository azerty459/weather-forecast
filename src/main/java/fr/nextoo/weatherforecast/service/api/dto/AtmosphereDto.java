package fr.nextoo.weatherforecast.service.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AtmosphereDto {

	@JsonProperty("temp")
	private double temperature;

	@JsonProperty("pressure")
	private double pressure;

	@JsonProperty("humidity")
	private int humidity;

	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getPressure() {
		return pressure;
	}
	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	
	@Override
	public String toString() {
		return "AtmosphereDto [temperature=" + temperature + ", pressure=" + pressure + ", humidity=" + humidity + "]";
	}

}
