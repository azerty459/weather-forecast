package nextoo.julien.meteo.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConditionCouranteReponseDto {
	
	@JsonProperty("humidity")
	private double humidity;
	
	@JsonProperty("tmp")
	private double temperatureActuelle;

	public ConditionCouranteReponseDto() {
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
