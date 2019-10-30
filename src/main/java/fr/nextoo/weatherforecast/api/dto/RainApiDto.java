package fr.nextoo.weatherforecast.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RainApiDto {

    private Float _3h;

    @JsonProperty("pourcentage")
    public Float get_3h() {
        return _3h;
    }

    @JsonProperty("3h")
    public void set_3h(Float _3h) {
        this._3h = _3h;
    }
}
