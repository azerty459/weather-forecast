package fr.nextoo.weatherforecast.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.List;

public class PrevisionApiDto {

    private Instant dt;
    private MainApiDto listMain;
    private java.util.List<WeatherApiDto> weather = null;
    private RainApiDto rain;

    @JsonProperty("main")
    public MainApiDto getListMain() {
        return listMain;
    }

    @JsonProperty("main")
    public void setListMain(MainApiDto listMain) {
        this.listMain = listMain;
    }

    @JsonProperty("dt")
    public Instant getDt() {
        return dt;
    }

    @JsonProperty("dt")
    public void setDt(Instant dt) {
         this.dt = dt;
    }

    @JsonProperty("weather")
    public List<WeatherApiDto> getWeather() {
        return weather;
    }

    @JsonProperty("weather")
    public void setWeather(List<WeatherApiDto> weather) {
        this.weather = weather;
    }

    @JsonProperty("rain")
    public RainApiDto getRain() {
        return (rain == null) ? new RainApiDto() : rain;
    }

    @JsonProperty("rain")
    public void setRain(RainApiDto rain) {
        this.rain = rain;
    }
}
