package fr.nextoo.weatherforecast.dto;

import java.util.List;

public class PrevisionDto {

    private String dateTime;
    private MainDto listMain;
    private List<WeatherDto> weather;
    private RainDto rain;

    public MainDto getListMain() {
        return listMain;
    }

    public void setListMain(MainDto listMain) {
        this.listMain = listMain;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String datetime) {
         this.dateTime = datetime;
    }

    public List<WeatherDto> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherDto> weather) {
        this.weather = weather;
    }

    public RainDto getRain() {
        return rain;
    }

    public void setRain(RainDto rain) {
        this.rain = rain;
    }
}
