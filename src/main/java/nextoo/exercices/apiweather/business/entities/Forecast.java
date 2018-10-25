package nextoo.exercices.apiweather.business.entities;

import java.util.List;

public class Forecast {

    private CurrentCondition currentCondition;

    private List<DayForecast> daysForcast;

    public Forecast() {
    }

    public CurrentCondition getCurrentCondition() {
        return currentCondition;
    }

    public void setCurrentCondition(CurrentCondition currentCondition) {
        this.currentCondition = currentCondition;
    }

    public List<DayForecast> getDaysForcast() {
        return daysForcast;
    }

    public void setDaysForcast(List<DayForecast> daysForcast) {
        this.daysForcast = daysForcast;
    }
}
