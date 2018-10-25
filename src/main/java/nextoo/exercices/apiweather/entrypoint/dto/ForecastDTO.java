package nextoo.exercices.apiweather.entrypoint.dto;

import java.util.List;

public class ForecastDTO {

    /**
     * Prévision générale
     */

    private CurrentConditionDTO currentCondition;

    private List<DayForecastDTO> daysForecast;

    public ForecastDTO() {
    }

    public CurrentConditionDTO getCurrentCondition() {
        return currentCondition;
    }

    public void setCurrentCondition(CurrentConditionDTO currentCondition) {
        this.currentCondition = currentCondition;
    }

    public List<DayForecastDTO> getDaysForecast() {
        return daysForecast;
    }

    public void setDaysForecast(List<DayForecastDTO> daysForecast) {
        this.daysForecast = daysForecast;
    }
}
