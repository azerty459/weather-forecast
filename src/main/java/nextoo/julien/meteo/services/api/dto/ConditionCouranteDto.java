package nextoo.julien.meteo.services.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConditionCouranteDto {
	
	@JsonProperty("humidity")
	private double humidity;
	
	@JsonProperty("tmp")
	private double temperatureActuelle;

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
		return temperatureActuelle;
	}

	public void setTemperatureActuelle(double temperatureActuelle) {
		this.temperatureActuelle = temperatureActuelle;
	}

	
	
	
	
	

}
