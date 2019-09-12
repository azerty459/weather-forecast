package fr.nextoo.weatherforecast.service.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CurrentForecastDto extends ForecastDto implements City {

	@JsonProperty("coord")
	private CoordinatesDto coordinates;

	@JsonProperty("id")
	private int cityId;
	@JsonProperty("name")
	private String cityName;

	public CoordinatesDto getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(CoordinatesDto coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public int getCityId() {
		return this.cityId;
	}
	@Override
	public void setCityId(int id) {
		this.cityId = id;
	}

	@Override
	public String getCityName() {
		return this.cityName;
	}
	@Override
	public void setCityName(String name) {
		this.cityName = name;
	}

	@Override
	public String toString() {
		return "CurrentForecastDto [coordinates=" + coordinates + ", cityId=" + cityId + ", cityName=" + cityName
				+ ", getSky()=" + getSky() + ", getAtmosphere()=" + getAtmosphere() + ", getWind()=" + getWind()
				+ ", getRain()=" + getRain() + ", getInstant()=" + getInstant() + "]";
	}

}
