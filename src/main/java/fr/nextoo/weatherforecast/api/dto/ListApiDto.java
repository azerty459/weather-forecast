package fr.nextoo.weatherforecast.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListApiDto {

    private Instant dt;
    private MainApiDto listMain;
    private java.util.List<WeatherApiDto> weather = null;
    private RainApiDto rain;

    DateTimeFormatter formatter =
            DateTimeFormatter.ofLocalizedDateTime( FormatStyle.SHORT )
                    .withLocale( Locale.UK )
                    .withZone( ZoneId.systemDefault() );

    @JsonProperty("info")
    public MainApiDto getListMain() {
        return listMain;
    }

    @JsonProperty("main")
    public void setListMain(MainApiDto listMain) {
        this.listMain = listMain;
    }

    @JsonProperty("dateTime")
    public String getDt() {
        return formatter.format(dt);
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

    @JsonProperty("precipitation")
    public RainApiDto getRain() {
        return rain;
    }

    @JsonProperty("rain")
    public void setRain(RainApiDto rain) {
        this.rain = rain;
    }
}
