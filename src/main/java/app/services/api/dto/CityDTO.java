package app.services.api.dto;

import app.services.api.entity.Forecast;

import java.util.ArrayList;


public class CityDTO {

    private String name;

    private Double humidity;

    private ArrayList<ForecastDTO> forecasts;

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ForecastDTO> getForecasts() { return forecasts; }

    public void setForecasts(ArrayList<ForecastDTO> forecasts) { this.forecasts = forecasts; }
}
