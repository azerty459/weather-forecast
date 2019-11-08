package fr.nextoo.weatherforecast.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ForecastApiDto {

    private List<PrevisionApiDto> list = null;
    private CityApiDto city;

    @JsonProperty("detail")
    public List<PrevisionApiDto> getList() {
        return list;
    }

    @JsonProperty("list")
    public void setList(List<PrevisionApiDto> list) {
        this.list = list;
    }

    @JsonProperty("city")
    public CityApiDto getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(CityApiDto city) {
        this.city = city;
    }
}
