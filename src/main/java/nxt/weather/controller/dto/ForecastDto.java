package nxt.weather.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForecastDto {
    
    private final String date;
    private final String nom;
    private final String condition;
    private final int temperatureMin;
    private final int temperatureMax;

    public ForecastDto(String date, String nom, String condition, int temperature_min, int temperature_max) {
        this.date = date;
        this.nom = nom;
        this.condition = condition;
        this.temperatureMin = temperature_min;
        this.temperatureMax = temperature_max;
    }

    public String getDate() {
        return date;
    }

    public String getNom() {
        return nom;
    }

    /*
    Indique à Jackson de nommer cette attribut prevision_general lors de la
    serialisation de l'objet en JSON
    */
    @JsonProperty("prevision_generale")
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
    
}
