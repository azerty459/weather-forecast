package nextoo.weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

public class PrevisionDTO {

    @JsonProperty("date")
    private String date;

    @JsonProperty("tmin")
    private double temperatureMin;

    @JsonProperty("tmax")
    private double temperatureMax;

    @JsonProperty("condition")
    private String condition;

    @JsonProperty("hourly_data")
    private HashMap<String, HourlyDataDTO> hourlyData;

    public PrevisionDTO() {
    }

    public HashMap<String, HourlyDataDTO> getHourlyData() {
        return hourlyData;
    }

    public void setHourlyData(HashMap<String, HourlyDataDTO> hourlyData) {
        this.hourlyData = hourlyData;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public double getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

}
