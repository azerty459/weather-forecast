package fr.nextoo.weatherforecast.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RainApiDto {

    private Double _3h;

    @JsonProperty("3h")
    public Double get_3h() {
        return (_3h == null) ? 0.0 : _3h;
    }

    @JsonProperty("3h")
    public void set_3h(Double _3h) {
        this._3h = _3h;
    }
}
