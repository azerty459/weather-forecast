package nextoo.julien.meteo.services.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrevisionHeureDto {

	@JsonProperty("RH2m")
	private double humidite;

	@JsonProperty("APCPsfc")
	private double precipitation;

	public PrevisionHeureDto() {
		super();
	}

	public double getHumidite() {
		return humidite;
	}

	public void setHumidite(double humidite) {
		this.humidite = humidite;
	}

	public double getPrecipitation() {
		return precipitation;
	}

	public void setPrecipitation(double precipitation) {
		this.precipitation = precipitation;
	}

}
