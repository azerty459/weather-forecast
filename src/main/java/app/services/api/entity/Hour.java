package app.services.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hour {

	@JsonProperty("RH2m")
	private Double RH2m;

	@JsonProperty("APCPsfc")
	private Double APCPsfc;

	public Double getRH2m() {
		return RH2m;
	}

	public void setRH2m(Double rH2m) {
		RH2m = rH2m;
	}

	public Double getAPCPsfc() {
		return APCPsfc;
	}

	public void setAPCPsfc(Double APCPsfc) {
		this.APCPsfc = APCPsfc;
	}
}
