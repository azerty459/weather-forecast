package nextoo.julien.meteo.services.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConditionCouranteDto {
	
	@JsonProperty("humidity")
	private double humidity;
	
	@JsonProperty("tmp")
	private double TemperatureActuelle;

	public ConditionCouranteDto() {
		super();
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public double getTemperatureActuelle() {
		return TemperatureActuelle;
	}

	public void setTemperatureActuelle(double temperatureActuelle) {
		TemperatureActuelle = temperatureActuelle;
	}
	
	
	
	

}
