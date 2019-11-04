package fr.nextoo.weatherforecast.dto;

import java.util.List;

public class ForecastDto {

    private List<ListDto> detailForecast = null;
    private CityDto ville;

    public List<ListDto> getDetailForecast() {
        return detailForecast;
    }

    public void setDetailForecast(List<ListDto> detailForecast) {
        this.detailForecast = detailForecast;
    }

    public CityDto getVille() {
        return ville;
    }

    public void setVille(CityDto ville) {
        this.ville = ville;
    }
}
