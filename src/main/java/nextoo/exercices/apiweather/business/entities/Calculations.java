package nextoo.exercices.apiweather.business.entities;

public class Calculations {

    /**
     * Température moyenne de la journée
     */
    private Float temperatureAverage;

    /**
     * Point de rosée moyen de la journée
     */
    private Float averageDewPoint;

    /**
     * Refroidissement éolien moyen de la journée
     */
    private Float averageWindChill;

    /**
     * Humidité relative moyenne de la journée
     */
    private Double averageRelativeHumidity;

    /**
     * Pression atmosphérique moyenne de la journée
     */
    private Float averageAtmosphericPressure;

    /**
     * Moyenne des précipitations de la journée
     */
    private Float averagePrecipitation;

    /**
     * Vitesse du vent moyenne de la journée
     */
    private Float averageWindSpeed;

    /**
     * Vitesse du vent en rafale de la journée
     */
    private Float averageWindGustSpeed;

    public Calculations() {
    }

    public Float getTemperatureAverage() {
        return temperatureAverage;
    }

    public void setTemperatureAverage(Float temperatureAverage) {
        this.temperatureAverage = temperatureAverage;
    }

    public Float getAverageDewPoint() {
        return averageDewPoint;
    }

    public void setAverageDewPoint(Float averageDewPoint) {
        this.averageDewPoint = averageDewPoint;
    }

    public Float getAverageWindChill() {
        return averageWindChill;
    }

    public void setAverageWindChill(Float averageWindChill) {
        this.averageWindChill = averageWindChill;
    }

    public Double getAverageRelativeHumidity() {
        return averageRelativeHumidity;
    }

    public void setAverageRelativeHumidity(Double averageRelativeHumidity) {
        this.averageRelativeHumidity = averageRelativeHumidity;
    }

    public Float getAverageAtmosphericPressure() {
        return averageAtmosphericPressure;
    }

    public void setAverageAtmosphericPressure(Float averageAtmosphericPressure) {
        this.averageAtmosphericPressure = averageAtmosphericPressure;
    }

    public Float getAveragePrecipitation() {
        return averagePrecipitation;
    }

    public void setAveragePrecipitation(Float averagePrecipitation) {
        this.averagePrecipitation = averagePrecipitation;
    }

    public Float getAverageWindSpeed() {
        return averageWindSpeed;
    }

    public void setAverageWindSpeed(Float averageWindSpeed) {
        this.averageWindSpeed = averageWindSpeed;
    }

    public Float getAverageWindGustSpeed() {
        return averageWindGustSpeed;
    }

    public void setAverageWindGustSpeed(Float averageWindGustSpeed) {
        this.averageWindGustSpeed = averageWindGustSpeed;
    }
}
