package fr.ia.meteo.meteo.job.prevision;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrevisionHoraire {

    private String condition;
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


