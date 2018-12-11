package com.nextoo.exercices.weatherforecast.dtos;

import java.util.Date;
import java.util.Map;

public class TownWeatherDayDto {

    private String ville;
    private Date jour;
    private Integer minTemp;
    private Integer maxTemp;
    private Integer vent;
    

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Map<String, String> getMeteoParJour() {
        return meteoParJour;
    }

    public void setMeteoParJour(Map<String, String> meteoParJour) {
        this.meteoParJour = meteoParJour;
    }
}
