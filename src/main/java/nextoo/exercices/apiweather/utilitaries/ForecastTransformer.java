package nextoo.exercices.apiweather.utilitaries;

import nextoo.exercices.apiweather.business.entities.DayForecast;
import nextoo.exercices.apiweather.business.entities.Forecast;
import nextoo.exercices.apiweather.entrypoint.dto.ForecastDTO;
import nextoo.exercices.apiweather.externalServices.previsionMeteoService.dto.PMSForecastDTO;

import java.util.ArrayList;
import java.util.List;

public class ForecastTransformer {

    public static ForecastDTO entityToDto(Forecast entity) {
        ForecastDTO result = new ForecastDTO();
        result.setCurrentCondition(CurrentConditionTransformer.entityToDto(entity.getCurrentCondition()));
        result.setDaysForecast(DayForecastTransformer.entityToDto(entity.getDaysForcast()));
        return result;
    }

    public static Forecast dtoToEntity(ForecastDTO dto) {
        Forecast result = new Forecast();
        result.setCurrentCondition(CurrentConditionTransformer.dtoToEntity(dto.getCurrentCondition()));
        result.setDaysForcast(DayForecastTransformer.dtoToEntity(dto.getDaysForecast()));
        return result;
    }

    public static Forecast pmsDtoToEntity(PMSForecastDTO pms) {
        Forecast result = new Forecast();
        result.setCurrentCondition(CurrentConditionTransformer.pmsDtoToEntity(pms.getCurrentCondition()));
        DayForecast df0 = DayForecastTransformer.pmsDtoToEntity(pms.getToday());
        DayForecast df1 = DayForecastTransformer.pmsDtoToEntity(pms.getTomorrow());
        DayForecast df2 = DayForecastTransformer.pmsDtoToEntity(pms.getInTwoDays());
        DayForecast df3 = DayForecastTransformer.pmsDtoToEntity(pms.getInThreeDays());
        DayForecast df4 = DayForecastTransformer.pmsDtoToEntity(pms.getInFourDays());

        List<DayForecast> dfs = new ArrayList<>();
        dfs.add(df0);
        dfs.add(df1);
        dfs.add(df2);
        dfs.add(df3);
        dfs.add(df4);
        result.setDaysForcast(dfs);

        return result;
    }
}
