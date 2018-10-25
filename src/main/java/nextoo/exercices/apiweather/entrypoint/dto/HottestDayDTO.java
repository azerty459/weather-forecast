package nextoo.exercices.apiweather.entrypoint.dto;

public class HottestDayDTO {

    private DayForecastDTO hottestDay;

    public HottestDayDTO() {
    }

    public DayForecastDTO getHottestDay() {
        return hottestDay;
    }

    public void setHottestDay(DayForecastDTO hottestDay) {
        this.hottestDay = hottestDay;
    }
}
