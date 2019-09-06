package fr.nextoo.weatherforecast.service.api.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastDto {

	@JsonProperty("weather")
	private List<SkyDto> sky;

	@JsonProperty("main")
	private AtmosphereDto atmosphere;

	@JsonProperty("wind")
	private WindDto wind;

	private Instant date;
	@JsonIgnore
	private Instant localDate;

	public List<SkyDto> getSky() {
		return sky;
	}
	public void setSky(List<SkyDto> sky) {
		this.sky = sky;
	}

	public AtmosphereDto getAtmosphere() {
		return atmosphere;
	}
	public void setAtmosphere(AtmosphereDto atmosphere) {
		this.atmosphere = atmosphere;
	}

	public WindDto getWind() {
		return wind;
	}
	public void setWind(WindDto wind) {
		this.wind = wind;
	}

	@JsonProperty("date")
	public Instant getDate() {
		return date;
	}
	@JsonProperty("dt")
	public void setDate(Instant date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ForecastDto [sky=" + sky + ", atmosphere=" + atmosphere + ", wind=" + wind + ", date=" + date + "]";
	}

}
