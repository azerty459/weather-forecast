package nextoo.exercices.apiweather.entrypoint.dto;

import nextoo.exercices.apiweather.business.entities.Calculations;
import nextoo.exercices.apiweather.business.entities.HourlyData;

import java.util.List;

public class DayForecastDTO {

    /**
     * Prévision pour une journée
     */

    private String date;

    private Integer minTemperature;

    private Integer maxTemperature;

    private String condition;

    private String icon;

    private CalculationsDTO averageData;

    private List<HourlyDataDTO> hourlyDatas;

    public DayForecastDTO(){
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

    public CalculationsDTO getAverageData() {
        return averageData;
    }

    public void setAverageData(CalculationsDTO averageData) {
        this.averageData = averageData;
    }

    public List<HourlyDataDTO> getHourlyDatas() {
        return hourlyDatas;
    }

    public void setHourlyDatas(List<HourlyDataDTO> hourlyDatas) {
        this.hourlyDatas = hourlyDatas;
    }
}
