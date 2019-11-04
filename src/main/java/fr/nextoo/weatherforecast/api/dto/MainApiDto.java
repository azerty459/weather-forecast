package fr.nextoo.weatherforecast.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MainApiDto {

    private Double temp;
    private Double temp_min;
    private Double temp_max;
    private Double humidity;

    @JsonProperty("temperature")
    public Double getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(Double temp) {
        this.temp = temp;
    }

    @JsonProperty("temperature_minimal")
    public Double getTemp_min() {
        return temp_min;
    }

    @JsonProperty("temp_min")
    public void setTemp_min(Double temp_min) {
        this.temp_min = temp_min;
    }

    @JsonProperty("temperature_maximal")
    public Double getTemp_max() {
        return temp_max;
    }

    @JsonProperty("temp_max")
    public void setTemp_max(Double temp_max) {
        this.temp_max = temp_max;
    }

    @JsonProperty("humidite")
    public Double getHumidity() {
        return humidity;
    }

    @JsonProperty("humidity")
    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }
}
