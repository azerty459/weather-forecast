package fr.nextoo.weatherforecast.dto;

import java.util.List;

public class PrevisionDto {

    private String dateTime;
    private DetailPrevisionDto listDetailPrevision;
    private List<WeatherDto> weather;
    private RainDto rain;

    public DetailPrevisionDto getListDetailPrevision() {
        return listDetailPrevision;
    }

    public void setListDetailPrevision(DetailPrevisionDto listDetailPrevision) {
        this.listDetailPrevision = listDetailPrevision;
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
