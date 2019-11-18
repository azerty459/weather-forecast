package com.nextoo.meteo.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherInfo {

	@JsonProperty("temp")
	private Double temperature;

	@JsonProperty("temp_min")
	private Double temperatureMinimum;

	@JsonProperty("temp_max")
	private Double temperatureMaximum;

	private Double pressure;

	private Integer humidity;

	public WeatherInfo() {

	}

	public WeatherInfo(Double temperature, Double temperatureMinimum, Double temperatureMaximum, Double pressure,
			Integer humidity) {
		super();
		this.temperature = temperature;
		this.temperatureMinimum = temperatureMinimum;
		this.temperatureMaximum = temperatureMaximum;
		this.pressure = pressure;
		this.humidity = humidity;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Double getTemperatureMinimum() {
		return temperatureMinimum;
	}

	public void setTemperatureMinimum(Double temperatureMinimum) {
		this.temperatureMinimum = temperatureMinimum;
	}

	public Double getTemperatureMaximum() {
		return temperatureMaximum;
	}

	public void setTemperatureMaximum(Double temperatureMaximum) {
		this.temperatureMaximum = temperatureMaximum;
	}

	public Double getPressure() {
		return pressure;
	}

	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}

	public Integer getHumidity() {
		return humidity;
	}

	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}

}
