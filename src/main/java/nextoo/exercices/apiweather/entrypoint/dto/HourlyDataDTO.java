package nextoo.exercices.apiweather.entrypoint.dto;

public class HourlyDataDTO {

    private int hour;

    private String icon;

    private String condition;

    private Float temp;

    private Float dewPoint;

    private Float windChill;

    private Float relativeHumidity;

    private Float atmosphericPressure;

    private Float precipitation;

    private Float windSpeed;

    private Float windGustSpeed;

    private Integer windDirectionDegree;

    private String windDirectionCardinal;

    public HourlyDataDTO() {
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
