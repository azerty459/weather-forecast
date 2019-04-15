package nxt.weather.service.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HourlyDataDto {

    @JsonProperty("RH2m")
    private int humidity;

    @JsonProperty("CONDITION_KEY")
    private String condition;

    @JsonProperty("APCPsfc")
    private double precipitation;

    @JsonProperty("TMP2m")
    private double temperature;


    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(int precipitation) {
        this.precipitation = precipitation;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
