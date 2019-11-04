package fr.nextoo.weatherforecast.dto;


public class MainDto {

    private Integer temperature;
    private Integer temperature_min;
    private Integer temperature_max;
    private Integer tauxHumidite;

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getTemperature_min() {
        return temperature_min;
    }

    public void setTemperature_min(Integer temperature_min) {
        this.temperature_min = temperature_min;
    }

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
