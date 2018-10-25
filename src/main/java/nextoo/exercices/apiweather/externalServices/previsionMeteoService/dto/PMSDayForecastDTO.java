package nextoo.exercices.apiweather.externalServices.previsionMeteoService.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PMSDayForecastDTO {

    private String date;

    @JsonSetter("tmin")
    private Integer minTemperature;

    @JsonSetter("tmax")
    private Integer maxTemperature;

    private String condition;

    private String icon;

    @JsonSetter("hourly_data")
    private PMSHourlyDatasListDTO hourlyDatas;

    public PMSDayForecastDTO() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Integer minTemperature) {
        this.minTemperature = minTemperature;
    }

    public Integer getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Integer maxTemperature) {
        this.maxTemperature = maxTemperature;
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

    public PMSHourlyDatasListDTO getHourlyDatas() {
        return hourlyDatas;
    }

    public void setHourlyDatas(PMSHourlyDatasListDTO hourlyDatas) {
        this.hourlyDatas = hourlyDatas;
    }
}

