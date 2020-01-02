package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Day {

    private String date;
    @JsonProperty("day_long")
    private String day;
    @JsonProperty("tmin")
    private Integer tempMin;
    @JsonProperty("tmax")
    private Integer tempMax;
    private String condition;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getTempMin() {
        return tempMin;
    }

    public void setTempMin(Integer tempMin) {
        this.tempMin = tempMin;
    }

    public Integer getTempMax() {
        return tempMax;
    }

    public void setTempMax(Integer tempMax) {
        this.tempMax = tempMax;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}