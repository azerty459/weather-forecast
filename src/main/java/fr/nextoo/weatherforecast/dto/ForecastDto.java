package fr.nextoo.weatherforecast.dto;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ForecastDto {

	@JsonProperty("city")
	private CityDto city;
	
	@JsonProperty("list")
	private WeatherDto[] weatherDays;
	
	public CityDto getCity() {
		return city;
	}
	
	public void setCity(CityDto city) {
		this.city = city;
	}
	
	public WeatherDto[] getWeatherDays() {
		return weatherDays;
	}
	
	public void setWeatherDays(WeatherDto[] weatherDays) {
		this.weatherDays = weatherDays;
	}

	@Override
	public String toString() {
		return "ForecastDto [city=" + city + ", weatherDays=" + Arrays.toString(weatherDays) + "]";
	}
	
}
