package com.nextoo.exercices.weatherforecast.dtos;

import com.nextoo.exercices.weatherforecast.utils.WeatherUtils;

import java.time.LocalDate;

/**
 * @author nextoo
 */
public class TownWeatherDayDto {

    private String ville;
    private LocalDate jour;
    private Double minTemp;
    private Double maxTemp;
    private Double vent;
    private Double humidite;
    private Double pression;
    private String description;
    private boolean jourPluvieux;

    public TownWeatherDayDto(final String ville,
            final LocalDate jour,
            final Double minTemp,
            final Double maxTemp,
            final Double vent,
            final Double humidite,
            final Double pression,
            final String description,
            final boolean jourPluvieux) {
        this.ville = ville;
        this.jour = jour;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.vent = vent;
        this.humidite = humidite;
        this.pression = pression;
        this.description = description;
        this.jourPluvieux = jourPluvieux;
    }


    @Override
    public String toString() {
        return "{ ville : " + getVille() +
                " jour : " + getFormattedDate() +
                " minTemp : " + getMinTemp() +
                " maxTemp : " + getMaxTemp() +
                " vent : " + getVent() +
                " pression : " + getPression() +
                " humidite : " + getHumidite() +
                " description : " + getDescription() +
                "}\n";
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Double minTemp) {
        this.minTemp = minTemp;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public Double getVent() {
        return vent;
    }

    public void setVent(Double vent) {
        this.vent = vent;
    }

    public Double getHumidite() {
        return humidite;
    }

    public void setHumidite(Double humidite) {
        this.humidite = humidite;
    }

    public Double getPression() {
        return pression;
    }

    public void setPression(Double pression) {
        this.pression = pression;
    }

    public LocalDate getJour() {
        return jour;
    }

    public void setJour(LocalDate jour) {
        this.jour = jour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFormattedDate() {
        return WeatherUtils.formatFullDate(jour);
    }

    public boolean isJourPluvieux() {
        return jourPluvieux;
    }

    public void setJourPluvieux(boolean jourPluvieux) {
        this.jourPluvieux = jourPluvieux;
    }
}
