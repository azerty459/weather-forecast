package nextoo.julien.meteo.services.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import nextoo.julien.meteo.controller.dto.ConditionCouranteReponseDto;

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

	public ConditionCouranteReponseDto convertToCondiCouranteReponseDto() {
		ConditionCouranteReponseDto conditionCourantReponse = new ConditionCouranteReponseDto();
		
		conditionCourantReponse.setHumidity(this.humidity);
		conditionCourantReponse.setTemperatureActuelle(this.temperatureActuelle);
		
		return conditionCourantReponse;
		
	}
	
	
	
	

}
