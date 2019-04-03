package nxt.weather.service.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastDayDto {
       
    private String date;
    private String day;
    private int tempMin;
    private int tempMax;
    private String condition;
    private String conditionKey;
    private Map<String, HourlyDataDto> hourly = new HashMap<>();

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    @JsonProperty("day_long")
    public void setDay(String day_long) {
        this.day = day_long;
    }

    public int getTempMin() {
        return tempMin;
    }

    @JsonProperty("tmin")
    public void setTempMin(int tmin) {
        this.tempMin = tmin;
    }

    public int getTempMax() {
        return tempMax;
    }

    @JsonProperty("tmax")
    public void setTempMax(int tmax) {
        this.tempMax = tmax;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getConditionKey() {
        return conditionKey;
    }

    @JsonProperty("condition_key")
    public void setConditionKey(String condition_key) {
        this.conditionKey = condition_key;
    }

    public Map<String, HourlyDataDto> getHourly() {
        return hourly;
    }

    @JsonProperty("hourly_data")
    public void setHourly(Map<String, HourlyDataDto> hourly_data) {
        this.hourly = hourly_data;
    }  
    
}
