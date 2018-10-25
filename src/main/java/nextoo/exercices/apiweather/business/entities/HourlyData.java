package nextoo.exercices.apiweather.business.entities;

import com.fasterxml.jackson.annotation.JsonSetter;

public class HourlyData {

    /**
     * Heure de la prévision
     */
    private int hour;

    /**
     * Icône correspondant à la condition de la prévision
     */
    private String icon;

    /**
     * Condition
     */
    private String condition;

    /**
     * Température
     */
    private Float temp;

    /**
     * Point de rosée
     */
    private Float dewPoint;

    /**
     * Refroidissement éolien
     */
    private Float windChill;

    /**
     * Humidité relative
     */
    private Float relativeHumidity;

    /**
     * Pression atmosphérique
     */
    private Float atmosphericPressure;

    /**
     * précipitation
     */
    private Float precipitation;

    /**
     * vitesse du vent
     */
    private Float windSpeed;

    /**
     * vitesse du vent en rafale
     */
    private Float windGustSpeed;

    /**
     * direction du vent (degrès)
     */
    private Integer windDirectionDegree;

    /**
     * direction du vent (lettres des points cardinaux)
     */
    private String windDirectionCardinal;

    public HourlyData() {
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Float getTemp() {
        return temp;
    }

    public void setTemp(Float temp) {
        this.temp = temp;
    }

    public Float getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(Float dewPoint) {
        this.dewPoint = dewPoint;
    }

    public Float getWindChill() {
        return windChill;
    }

    public void setWindChill(Float windChill) {
        this.windChill = windChill;
    }

    public Float getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(Float relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    public Float getAtmosphericPressure() {
        return atmosphericPressure;
    }

    public void setAtmosphericPressure(Float atmosphericPressure) {
        this.atmosphericPressure = atmosphericPressure;
    }

    public Float getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Float precipitation) {
        this.precipitation = precipitation;
    }

    public Float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Float getWindGustSpeed() {
        return windGustSpeed;
    }

    public void setWindGustSpeed(Float windGustSpeed) {
        this.windGustSpeed = windGustSpeed;
    }

    public Integer getWindDirectionDegree() {
        return windDirectionDegree;
    }

    public void setWindDirectionDegree(Integer windDirectionDegree) {
        this.windDirectionDegree = windDirectionDegree;
    }

    public String getWindDirectionCardinal() {
        return windDirectionCardinal;
    }

    public void setWindDirectionCardinal(String windDirectionCardinal) {
        this.windDirectionCardinal = windDirectionCardinal;
    }
}
