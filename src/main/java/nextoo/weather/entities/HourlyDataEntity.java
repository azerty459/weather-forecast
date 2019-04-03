package nextoo.weather.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HourlyDataEntity {

    @JsonProperty("CONDITION")
    private String condition;

    @JsonProperty("TMP2m")
    private Double temperature;

    @JsonProperty("APCPsfc")
    private Double precipitation;

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
