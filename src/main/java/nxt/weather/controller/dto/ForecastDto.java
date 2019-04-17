package nxt.weather.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ForecastDto {
    
    private final String date;
    private final String name;
    private final String condition;
    private final int temperatureMin;
    private final int temperatureMax;
    private final String icon;
    private HourlyDto[] hourly;

    public ForecastDto(String date, String name, String condition, int temperature_min, int temperature_max, String icon) {
        this(date, name, condition, temperature_min, temperature_max, icon, null);
    }

    public ForecastDto(String date, String name, String condition, int temperatureMin, int temperatureMax, String icon, HourlyDto[] hourly) {
        this.date = date;
        this.name = name;
        this.condition = condition;
        this.temperatureMin = temperatureMin;
        this.temperatureMax = temperatureMax;
        this.icon = icon;
        this.hourly = hourly;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    /*
    Indique à Jackson de nommer cette attribut prevision_general lors de la
    serialisation de l'objet en JSON
    */
    @JsonProperty("general_forecast")
    public String getCondition() {
        return condition;
    }

    @JsonProperty("temparature_min")
    public int getTemperatureMin() {
        return temperatureMin;
    }

    @JsonProperty("temparature_max")
    public int getTemperatureMax() {
        return temperatureMax;
    }

    public String getIcon() {
        return icon;
    }

    public HourlyDto[] getHourly() {
        return hourly;
    }
}
