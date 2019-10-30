package fr.nextoo.weatherforecast.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MainApiDto {

    private Float temp;
    private Float temp_min;
    private Float temp_max;
    private Integer humidity;

    @JsonProperty("temperature")
    public Float getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(Float temp) {
        this.temp = temp;
    }

    @JsonProperty("temperature_minimal")
    public Float getTemp_min() {
        return temp_min;
    }

    @JsonProperty("temp_min")
    public void setTemp_min(Float temp_min) {
        this.temp_min = temp_min;
    }

    @JsonProperty("temperature_maximal")
    public Float getTemp_max() {
        return temp_max;
    }

    @JsonProperty("temp_max")
    public void setTemp_max(Float temp_max) {
        this.temp_max = temp_max;
    }

    @JsonProperty("humidite")
    public Integer getHumidity() {
        return humidity;
    }

    @JsonProperty("humidity")
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }
}
