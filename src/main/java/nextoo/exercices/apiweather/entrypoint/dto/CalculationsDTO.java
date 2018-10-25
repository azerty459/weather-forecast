package nextoo.exercices.apiweather.entrypoint.dto;

public class CalculationsDTO {

    /**
     * Température moyenne de la journée
     */
    private Float temperatureAverage;

    /**
     * Point de rosée moyen de la journée
     */
    private Float dewPointAverage;

    /**
     * Refroidissement éolien moyen de la journée
     */
    private Float windChillAverage;

    /**
     * Humidité relative moyenne de la journée
     */
    private Float relativeHumidityAverage;

    /**
     * Pression atmosphérique moyenne de la journée
     */
    private Float atmosphericPressureAverage;

    /**
     * Moyenne des précipitations de la journée
     */
    private Float precipitationAverage;

    /**
     * Vitesse du vent moyenne de la journée
     */
    private Float windSpeedAverage;

    /**
     * Vitesse du vent en rafale de la journée
     */
    private Float windGustSpeedAverage;

    public CalculationsDTO() {
    }

    public Float getTemperatureAverage() {
        return temperatureAverage;
    }

    public void setTemperatureAverage(Float temperatureAverage) {
        this.temperatureAverage = temperatureAverage;
    }

    public Float getDewPointAverage() {
        return dewPointAverage;
    }

    public void setDewPointAverage(Float dewPointAverage) {
        this.dewPointAverage = dewPointAverage;
    }

    public Float getWindChillAverage() {
        return windChillAverage;
    }

    public void setWindChillAverage(Float windChillAverage) {
        this.windChillAverage = windChillAverage;
    }

    public Float getRelativeHumidityAverage() {
        return relativeHumidityAverage;
    }

    public void setRelativeHumidityAverage(Float relativeHumidityAverage) {
        this.relativeHumidityAverage = relativeHumidityAverage;
    }

    public Float getAtmosphericPressureAverage() {
        return atmosphericPressureAverage;
    }

    public void setAtmosphericPressureAverage(Float atmosphericPressureAverage) {
        this.atmosphericPressureAverage = atmosphericPressureAverage;
    }

    public Float getPrecipitationAverage() {
        return precipitationAverage;
    }

    public void setPrecipitationAverage(Float precipitationAverage) {
        this.precipitationAverage = precipitationAverage;
    }

    public Float getWindSpeedAverage() {
        return windSpeedAverage;
    }

    public void setWindSpeedAverage(Float windSpeedAverage) {
        this.windSpeedAverage = windSpeedAverage;
    }

    public Float getWindGustSpeedAverage() {
        return windGustSpeedAverage;
    }

    public void setWindGustSpeedAverage(Float windGustSpeedAverage) {
        this.windGustSpeedAverage = windGustSpeedAverage;
    }
}
