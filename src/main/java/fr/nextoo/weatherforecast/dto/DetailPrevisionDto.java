package fr.nextoo.weatherforecast.dto;


public class DetailPrevisionDto {

    private Integer temperature_max;
    private Integer tauxHumidite;

    public Integer getTemperature_max() {
        return temperature_max;
    }

    public void setTemperature_max(Integer temperature_max) {
        this.temperature_max = temperature_max;
    }

    public Integer getTauxHumidite() {
        return tauxHumidite;
    }

    public void setTauxHumidite(Integer tauxHumidite) {
        this.tauxHumidite = tauxHumidite;
    }
}
