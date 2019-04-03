package nextoo.weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HourlyDataDTO {

    @JsonProperty("CONDITION")
    private String condition;

    @JsonProperty("TMP2m")
    private Double temperature;

    @JsonProperty("APCPsfc")
    private Double precipitation;

    @JsonProperty("RH2m")
    private Double humidity;

    public HourlyDataDTO() {
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Double precipitation) {
        this.precipitation = precipitation;
    }
}
