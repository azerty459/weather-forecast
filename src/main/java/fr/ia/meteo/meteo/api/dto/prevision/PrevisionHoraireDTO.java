package fr.ia.meteo.meteo.api.dto.prevision;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrevisionHoraireDTO {

    @JsonProperty("CONDITION")
    private String condition;

    @JsonProperty("RH2m")
    private Integer tauxHumidite;

   @JsonProperty("APCPsfc")
   private Integer qtePrecipitation;

    private Integer heurePrevisionHoraire;



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

    public Integer getQtePrecipitation() {
        return qtePrecipitation;
    }

    public void setQtePrecipitation(Integer qtePrecipitation) {
        this.qtePrecipitation = qtePrecipitation;
    }

    @Override
    public String toString() {
        return "PrevisionHoraire{" +
                "condition='" + condition + '\'' +
                ", tauxHumidite=" + tauxHumidite +
                '}';
    }
}


