package nxt.weather.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TodayDto {

    private String name;
    private String country;
    private String sunrise;
    private String sunset;
    private int temperature;
    @JsonProperty("wind_speed")
    private int windSpeed;
    @JsonProperty("wind_direction")
    private String windDir;
    private double pressure;
    private int humidity;
    private String condition;
    @JsonProperty("days")
    private List<ForecastDto> forecast;

    public TodayDto(String name, String country, String sunrise, String sunset, int temperature, int windSpeed, String windDir, double pressure, int humidity, String condition, List<ForecastDto> forecast) {
        this.name = name;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDir = windDir;
        this.pressure = pressure;
        this.humidity = humidity;
        this.condition = condition;
        this.forecast = forecast;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getSunrise() {
        return sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public String getWindDir() {
        return windDir;
    }

    public double getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public String getCondition() {
        return condition;
    }

    public List<ForecastDto> getForecast() {
        return forecast;
    }
}
