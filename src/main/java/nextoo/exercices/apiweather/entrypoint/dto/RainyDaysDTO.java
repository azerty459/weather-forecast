package nextoo.exercices.apiweather.entrypoint.dto;

import java.util.List;

public class RainyDaysDTO {

    private List<DayForecastDTO> rainyDays;

    public RainyDaysDTO() {
    }

    public List<DayForecastDTO> getRainyDays() {
        return rainyDays;
    }

    public void setRainyDays(List<DayForecastDTO> rainyDays) {
        this.rainyDays = rainyDays;
    }
}
