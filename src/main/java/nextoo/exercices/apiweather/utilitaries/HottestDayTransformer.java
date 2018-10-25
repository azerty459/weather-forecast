package nextoo.exercices.apiweather.utilitaries;

import nextoo.exercices.apiweather.business.entities.DayForecast;
import nextoo.exercices.apiweather.entrypoint.dto.HottestDayDTO;

public class HottestDayTransformer {

    public static HottestDayDTO entityToDto(DayForecast entity) {
        HottestDayDTO result = new HottestDayDTO();
        result.setHottestDay(DayForecastTransformer.entityToDto(entity));
        return result;
    }
}
