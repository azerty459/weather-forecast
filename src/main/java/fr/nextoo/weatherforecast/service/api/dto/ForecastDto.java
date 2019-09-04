package fr.nextoo.weatherforecast.service.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ForecastDto {

	@JsonProperty("city")
	private CityDto city;
	
	@JsonProperty("list")
	private List<WeatherDto> weatherDays;
	
	public CityDto getCity() {
		return city;
	}
	
	public void setCity(CityDto city) {
		this.city = city;
	}

	public List<WeatherDto> getWeatherDays() {
		return weatherDays;
	}

	public void setWeatherDays(List<WeatherDto> weatherDays) {
		this.weatherDays = weatherDays;
	}

	@Override
	public String toString() {
		return "ForecastDto [city=" + city + ", weatherDays=" + weatherDays + "]";
	}
	
}
