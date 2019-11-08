package fr.nextoo.weatherforecast.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherDto {

    private String description;
    private Boolean isRainning;

    @JsonProperty("detailMeteo")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsRainning() {
        return isRainning;
    }

    public void setIsRainning(Boolean isRainning) {
        this.isRainning = isRainning;
    }

}
