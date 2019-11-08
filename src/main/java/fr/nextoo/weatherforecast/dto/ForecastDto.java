package fr.nextoo.weatherforecast.dto;

import java.util.List;

public class ForecastDto {

    private List<PrevisionDto> detailForecast = null;
    private CityDto ville;

    public List<PrevisionDto> getDetailForecast() {
        return detailForecast;
    }

    public void setDetailForecast(List<PrevisionDto> detailForecast) {
        this.detailForecast = detailForecast;
    }

    public CityDto getVille() {
        return ville;
    }

    public void setVille(CityDto ville) {
        this.ville = ville;
    }
}
