package nextoo.julien.meteo.services.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrevisionHeureDto {

	@JsonProperty("RH2m")
	private double humidite;

	public PrevisionHeureDto() {
		super();
	}

	public double getHumidite() {
		return humidite;
	}

	public void setHumidite(double humidite) {
		this.humidite = humidite;
	}
	
	
}
