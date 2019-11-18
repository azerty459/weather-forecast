package com.nextoo.meteo.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {

	@JsonProperty("main")
	private WeatherInfo weatherInfo;

	private List<Weather> weather;

	@JsonProperty("dt_txt")
	private String datetime;
	
	
	public Forecast() {

	}


	public Forecast(WeatherInfo weatherInfo, List<Weather> weather, String datetime) {
		super();
		this.weatherInfo = weatherInfo;
		this.weather = weather;
		this.datetime = datetime;
	}


	public WeatherInfo getWeatherInfo() {
		return weatherInfo;
	}


	public void setWeatherInfo(WeatherInfo weatherInfo) {
		this.weatherInfo = weatherInfo;
	}


	public List<Weather> getWeather() {
		return weather;
	}


	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}


	public String getDatetime() {
		return datetime;
	}


	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

}
