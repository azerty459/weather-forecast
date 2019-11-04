package fr.nextoo.weatherforecast.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.org.apache.xpath.internal.operations.Bool;

public class WeatherDto {

    private String main;
    private String description;
    private Boolean ilPleut;
    private String icon;

    @JsonProperty("meteo")
    public String getMain() {
        return main;
    }

    @JsonProperty("main")
    public void setMain(String main) {
        this.main = main;
    }

    @JsonProperty("detailMeteo")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIlPleut() {
        return ilPleut;
    }

    public void setIlPleut(Boolean ilPleut) {
        this.ilPleut = ilPleut;
    }

    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }
}
