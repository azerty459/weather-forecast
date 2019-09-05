package fr.nextoo.weatherforecast.service.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class City5DaysForecastDto {

	@JsonProperty("city")
	private CityDto city;
	
	@JsonProperty("list")
	private List<ForecastDto> forecasts;

	public CityDto getCity() {
		return city;
	}
	public void setCity(CityDto city) {
		this.city = city;
	}

	public List<ForecastDto> getForecasts() {
		return forecasts;
	}
	public void setForecasts(List<ForecastDto> forecasts) {
		this.forecasts = forecasts;
	}

	@Override
	public String toString() {
		return "City5DaysForecastDto [city=" + city + ", forecasts=" + forecasts + "]";
	}
	
}
