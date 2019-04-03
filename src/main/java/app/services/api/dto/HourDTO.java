package app.services.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HourDTO {
	
	@JsonProperty("RH2m")
	private Double RH2m;
	
	public HourDTO() {
		
	}

	public Double getRH2m() {
		return RH2m;
	}

	public void setRH2m(Double rH2m) {
		RH2m = rH2m;
	}
	
	

}
