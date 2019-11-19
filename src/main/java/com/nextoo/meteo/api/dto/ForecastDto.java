package com.nextoo.meteo.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastDto {

	@JsonProperty("main")
	private WeatherInfoDto weatherInfo;

	private List<WeatherDto> weather;

	@JsonProperty("dt_txt")
	private String datetime;
	
	
	public ForecastDto() {

	}


	public ForecastDto(WeatherInfoDto weatherInfo, List<WeatherDto> weather, String datetime) {
		super();
		this.weatherInfo = weatherInfo;
		this.weather = weather;
		this.datetime = datetime;
	}


	public WeatherInfoDto getWeatherInfo() {
		return weatherInfo;
	}


	public void setWeatherInfo(WeatherInfoDto weatherInfo) {
		this.weatherInfo = weatherInfo;
	}


	public List<WeatherDto> getWeather() {
		return weather;
	}


	public void setWeather(List<WeatherDto> weather) {
		this.weather = weather;
	}


	public String getDatetime() {
		return datetime;
	}


	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

}
