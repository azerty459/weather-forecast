package fr.nextoo.weatherforecast.service.api.dto;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import fr.nextoo.weatherforecast.interfaces.City;

@JsonIgnoreProperties(ignoreUnknown=true)
public class NextDaysForecastsDto implements City{

	@JsonProperty("city")
	private void unpackNestedCity(Map<String, Object> city) {
		if(MapUtils.isNotEmpty(city)){
			this.cityId = (int)city.get("id");
			this.cityName = (String)city.get("name");
		}
	}

	private int cityId;
	private String cityName;

	@JsonProperty("list")
	private List<ForecastDto> forecasts;

	public List<ForecastDto> getForecasts() {
		return forecasts;
	}
	public void setForecasts(List<ForecastDto> forecasts) {
		this.forecasts = forecasts;
	}

	@Override
	public int getCityId() {
		return this.cityId;
	}
	@Override
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	@Override
	public String getCityName() {
		return this.cityName;
	}
	@Override
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "City5DaysForecastDto [cityId=" + cityId + ", cityName=" + cityName + ", forecasts=" + forecasts + "]";
	}

}
