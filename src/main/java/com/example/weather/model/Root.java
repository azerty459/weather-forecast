package com.example.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Repository;

@Repository
public class Root {

    @JsonProperty("city_info")
    private City city;

    @JsonProperty("current_condition")
    private CurrentCondition currentCondition;

    @JsonProperty("fcst_day_0")
    private Day day0;

    @JsonProperty("fcst_day_1")
    private Day day1;

    @JsonProperty("fcst_day_2")
    private Day day2;

    @JsonProperty("fcst_day_3")
    private Day day3;

    @JsonProperty("fcst_day_4")
    private Day day4;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public CurrentCondition getCurrentCondition() {
        return currentCondition;
    }

    public void setCurrentCondition(CurrentCondition currentCondition) {
        this.currentCondition = currentCondition;
    }

    public Day getDay0() {
        return day0;
    }

    public void setDay0(Day day0) {
        this.day0 = day0;
    }

    public Day getDay1() {
        return day1;
    }

    public void setDay1(Day day1) {
        this.day1 = day1;
    }

    public Day getDay2() {
        return day2;
    }

    public void setDay2(Day day2) {
        this.day2 = day2;
    }

    public Day getDay3() {
        return day3;
    }

    public void setDay3(Day day3) {
        this.day3 = day3;
    }

    public Day getDay4() {
        return day4;
    }

    public void setDay4(Day day4) {
        this.day4 = day4;
    }
}
