package nxt.weather.service.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HourlyDataDto {
    
    private int humidity;
    private String condition;
    
    @JsonProperty("RH2m")
    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
    
    public int getHumidity() {
        return humidity;
    }
    
    @JsonProperty("CONDITION_KEY")
    public void setCondition(String condition) {
        this.condition = condition;
    }
    
    public String getCondition() {
        return condition;
    }
    
}
