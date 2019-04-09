package nextoo.exo1.meteorest.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PrevisionJourDTO {

    /**
     * Represente l'evolution de l'humidite par heure
     */
    @JsonProperty("hourly_data")
    Map<String, PrevisionHeureDTO> parHeure = new HashMap<String, PrevisionHeureDTO>();

    /**
     * Represente la date du bulletin meteo.
     */
    @JsonProperty("date")
    private String dateDuBulletin;

    /**
     * Exprime les conditions, si il pleut, si il y a du soleil...
     */
    @JsonProperty("condition_key")
    private String condition;

    /**
     * Represente soit la temperature actuelle pour la meteo du jour, soit la meteo prevue pour une prevision.
     */
    @JsonProperty("tmp")
    private double temperature;

    /**
     * Represente le niveau d'humidite
     */
    @JsonProperty("humidity")
    private int humidite;

    /**
     * Represente la temperature minimale pour la date renseignee.
     */
    @JsonProperty("tmin")
    private double temperatureMin;

    /**
     * Represente la temperature maximale pour la date renseingnee.
     */
    @JsonProperty("tmax")
    private double temperatureMax;

    @JsonProperty("icon")
    private String icon;

    @JsonProperty("icon_big")
    private String icon_big;

    public PrevisionJourDTO() {

    }

    /**
     * @return the dateDuBulletin
     */
    public String getDateDuBulletin() {
        return dateDuBulletin;
    }

    /**
     * @param dateDuBulletin the dateDuBulletin to set
     */
    public void setDateDuBulletin(String dateDuBulletin) {
        this.dateDuBulletin = dateDuBulletin;
    }

    /**
     * @return the temperatureActuelle
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * @param temperature la temperature Actuelle to set
     */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    /**
     * @return the temperatureMin
     */
    public double getTemperatureMin() {
        return temperatureMin;
    }

    /**
     * @param temperatureMin the temperatureMin to set
     */
    public void setTemperatureMin(double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    /**
     * @return the temperatureMax
     */
    public double getTemperatureMax() {
        return temperatureMax;
    }

    /**
     * @param temperatureMax the temperatureMax to set
     */
    public void setTemperatureMax(double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    /**
     * @return the condition
     */
    public String getCondition() {
        return condition;
    }

    /**
     * @param condition the condition to set
     */
    public void setCondition(String condition) {
        this.condition = condition;
    }

    /**
     * @return the humidite
     */
    public int getHumidite() {
        return humidite;
    }

    /**
     * @param humidite the humidite to set
     */
    public void setHumidite(int humidite) {
        this.humidite = humidite;
    }

    /**
     * @return the parHeure
     */
    public Map<String, PrevisionHeureDTO> getParHeure() {
        return parHeure;
    }

    /**
     * @param parHeure the parHeure to set
     */
    public void setParHeure(Map<String, PrevisionHeureDTO> parHeure) {
        this.parHeure = parHeure;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setIcon_big(String icon_big) {
        this.icon_big = icon_big;
    }

    public String getIcon_big() {
        return icon_big;
    }
}
