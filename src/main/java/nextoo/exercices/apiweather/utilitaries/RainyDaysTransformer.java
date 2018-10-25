package nextoo.exercices.apiweather.utilitaries;

import nextoo.exercices.apiweather.business.entities.DayForecast;
import nextoo.exercices.apiweather.entrypoint.dto.RainyDaysDTO;

import java.util.List;

public class RainyDaysTransformer {
    public static RainyDaysDTO entityToDto(List<DayForecast> entity) {
        RainyDaysDTO result = new RainyDaysDTO();
        result.setRainyDays(DayForecastTransformer.entityToDto(entity));
        return result;
    }
}
