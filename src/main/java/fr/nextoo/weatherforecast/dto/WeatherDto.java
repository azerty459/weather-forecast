package fr.nextoo.weatherforecast.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDto {

	@JsonProperty("weather")
	private List<SkyDto> sky;

	@JsonProperty("main")
	private AtmosphereDto atmosphere;

	@JsonProperty("wind")
	private WindDto wind;

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

	@Override
	public String toString() {
		return "WeatherDto [sky=" + sky + ", atmosphere=" + atmosphere + ", wind=" + wind + "]";
	}

}
