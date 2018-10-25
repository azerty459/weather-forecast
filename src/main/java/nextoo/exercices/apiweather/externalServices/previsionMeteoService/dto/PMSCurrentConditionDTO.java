package nextoo.exercices.apiweather.externalServices.previsionMeteoService.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PMSCurrentConditionDTO {

    private String date;

    private String hour;

    @JsonSetter("tmp")
    private Integer temperature;

    @JsonSetter("wnd_spd")
    private Integer windSpeed;

    @JsonSetter("wnd_gust")
    private Integer windGustSpeed;

    @JsonSetter("wnd_dir")
    private String windDirection;

    private Float pressure;

    private Integer humidity;

    private String condition;

    @JsonSetter("icon_big")
    private String icon;

    public PMSCurrentConditionDTO() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Integer windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Integer getWindGustSpeed() {
        return windGustSpeed;
    }

    public void setWindGustSpeed(Integer windGustSpeed) {
        this.windGustSpeed = windGustSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public Float getPressure() {
        return pressure;
    }

    public void setPressure(Float pressure) {
        this.pressure = pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
