package fr.nextoo.weatherforecast.service.api.dto;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;

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

	@JsonIgnore
	private double rain;

	@JsonProperty("rain")
	private void unpackNestedRain(Map<String, Object> rain) {
		if(MapUtils.isNotEmpty(rain)) {
			this.rain = (double)rain.get("3h");
		}
	}

	@JsonProperty("dt")
	private Instant instant;

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

	public double getRain() {
		return rain;
	}
	public void setRain(double rain) {
		this.rain = rain;
	}

	public Instant getInstant() {
		return instant;
	}
	public void setInstant(Instant instant) {
		this.instant = instant;
	}

	@Override
	public String toString() {
		return "ForecastDto [sky=" + sky + ", atmosphere=" + atmosphere + ", wind=" + wind + ", rain=" + rain
				+ ", instant=" + instant + "]";
	}

}
