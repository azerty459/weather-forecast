package fr.ia.meteo.meteo.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrevisionHoraireDTO {

    @JsonProperty("CONDITION")
    private String condition;

    @JsonProperty("RH2m")
    private Integer tauxHumidite;


    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Integer getTauxHumidite() {
        return tauxHumidite;
    }

    public void setTauxHumidite(Integer tauxHumidite) {
        this.tauxHumidite = tauxHumidite;
    }

    @Override
    public String toString() {
        return "PrevisionHoraire{" +
                "condition='" + condition + '\'' +
                ", tauxHumidite=" + tauxHumidite +
                '}';
    }
}


