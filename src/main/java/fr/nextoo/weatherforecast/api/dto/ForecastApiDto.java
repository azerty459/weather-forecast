package fr.nextoo.weatherforecast.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.nextoo.weatherforecast.api.dto.CityApiDto;
import fr.nextoo.weatherforecast.api.dto.ListApiDto;

import java.util.List;

public class ForecastApiDto {

    private List<ListApiDto> list = null;
    private CityApiDto city;

    @JsonProperty("detail")
    public List<ListApiDto> getList() {
        return list;
    }

    @JsonProperty("list")
    public void setList(List<ListApiDto> list) {
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
