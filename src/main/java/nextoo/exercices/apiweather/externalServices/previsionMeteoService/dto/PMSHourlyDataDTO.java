package nextoo.exercices.apiweather.externalServices.previsionMeteoService.dto;

import com.fasterxml.jackson.annotation.JsonSetter;

public class PMSHourlyDataDTO {

    @JsonSetter("ICON")
    private String icon;

    @JsonSetter("CONDITION")
    private String condition;

    @JsonSetter("TMP2m")
    private Float temp;

    @JsonSetter("DPT2m")
    private Float dewPoint;

    @JsonSetter("WNDCHILL2m")
    private Float windChill;

    @JsonSetter("RH2m")
    private Float relativeHumidity;

    @JsonSetter("PRMSL")
    private Float atmosphericPressure;

    @JsonSetter("APCPsfc")
    private Float precipitation;

    @JsonSetter("WNDSPD10m")
    private Float windSpeed;

    @JsonSetter("WNDGUST10m")
    private Float windGustSpeed;

    @JsonSetter("WNDDIR10m")
    private Integer windDirectionDegree;

    @JsonSetter("WNDDIRCARD10")
    private String windDirectionCardinal;

    public PMSHourlyDataDTO() {
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
