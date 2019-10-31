package fr.nextoo.weatherforecast.dto;

public class WeatherDto {

    private String date;
    private Double temperature_max;
    private Double temperature_min;
    private Double humidite;
    private Boolean ilPleut;

    public WeatherDto(String date, Double temperature_max, Double temperature_min, Double humidite, boolean ilPleut) {
        this.date = date;
        this.temperature_max = temperature_max;
        this.temperature_min = temperature_min;
        this.humidite = humidite;
        this.ilPleut = ilPleut;
    }

    @Override
    public String toString() {
        return "WeatherDto{" +
                ", date='" + date + '\'' +
                ", temperature_max=" + temperature_max +
                ", temperature_min=" + temperature_min +
                ", humidite=" + humidite +
                ", ilPleut=" + ilPleut +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getTemperature_max() {
        return temperature_max;
    }

    public void setTemperature_max(Double temperature_max) {
        this.temperature_max = temperature_max;
    }

    public Double getTemperature_min() {
        return temperature_min;
    }

    public void setTemperature_min(Double temperature_min) {
        this.temperature_min = temperature_min;
    }

    public Double getHumidite() {
        return humidite;
    }
    public void setHumidite(Double humidite) {
        this.humidite = humidite;
    }

    public Boolean getIlPleut() {
        return ilPleut;
    }

    public void setIlPleut(Boolean ilPleut) {
        this.ilPleut = ilPleut;
    }
}
