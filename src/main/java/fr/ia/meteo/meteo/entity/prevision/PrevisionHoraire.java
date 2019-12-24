package fr.ia.meteo.meteo.entity.prevision;

public class PrevisionHoraire {

    private String condition;
    private Integer tauxHumidite;
    private Integer heurePrevisionHoraire ;
    private Integer qtePrecipitation;



    public Integer getHeurePrevisionHoraire() {
        return heurePrevisionHoraire;
    }

    public void setHeurePrevisionHoraire(Integer heurePrevisionHoraire) {
        this.heurePrevisionHoraire = heurePrevisionHoraire;
    }

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


