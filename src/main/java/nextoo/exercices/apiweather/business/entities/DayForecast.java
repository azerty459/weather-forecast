package nextoo.exercices.apiweather.business.entities;

import java.util.List;
import java.util.stream.Stream;

public class DayForecast {

    private static final String[] RAIN_STATUS_KEY_WORDS = {"averse", "pluie"};

    private String date;

    private Integer minTemperature;

    private Integer maxTemperature;

    private String condition;

    private String icon;

    private Calculations averageData;

    private List<HourlyData> hourlyDatas;

    public DayForecast(){
    }

    public static boolean isRainy(DayForecast df) {
        return Stream.of(RAIN_STATUS_KEY_WORDS)
                .anyMatch(rs -> df.getCondition().toLowerCase().contains(rs.toLowerCase()));
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

    public Calculations getAverageData() {
        return averageData;
    }

    public void setAverageData(Calculations averageData) {
        this.averageData = averageData;
    }

    public List<HourlyData> getHourlyDatas() {
        return hourlyDatas;
    }

    public void setHourlyDatas(List<HourlyData> hourlyDatas) {
        this.hourlyDatas = hourlyDatas;
    }
}
