package fr.ia.meteo.meteo.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrevisionHoraireDTO {

    @JsonProperty("CONDITION")
    private String condition;

    @JsonProperty("RH2m")
    private Integer tauxHumidite;
    private Integer heurePrevisionHoraire ;


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


    public Integer getHeurePrevisionHoraire() {
        return heurePrevisionHoraire;
    }

    public void setHeurePrevisionHoraire(Integer heurePrevisionHoraire) {
        this.heurePrevisionHoraire = heurePrevisionHoraire;
    }

    @Override
    public String toString() {
        return "PrevisionHoraire{" +
                "condition='" + condition + '\'' +
                ", tauxHumidite=" + tauxHumidite +
                '}';
    }
}


