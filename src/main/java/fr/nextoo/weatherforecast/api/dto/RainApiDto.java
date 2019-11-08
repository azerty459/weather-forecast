package fr.nextoo.weatherforecast.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RainApiDto {

    private Double tauxPrecipitation;

    @JsonProperty("3h")
    public Double getTauxPrecipitation() {
        return (tauxPrecipitation == null) ? 0.0 : tauxPrecipitation;
    }

    @JsonProperty("3h")
    public void setTauxPrecipitation(Double tauxPrecipitation) {
        this.tauxPrecipitation = tauxPrecipitation;
    }
}
