package nextoo.exercices.apiweather.business;

import nextoo.exercices.apiweather.business.entities.Calculations;
import nextoo.exercices.apiweather.business.entities.DayForecast;
import nextoo.exercices.apiweather.business.entities.Forecast;
import nextoo.exercices.apiweather.business.entities.HourlyData;
import nextoo.exercices.apiweather.entrypoint.dto.ForecastDTO;
import nextoo.exercices.apiweather.entrypoint.dto.HottestDayDTO;
import nextoo.exercices.apiweather.entrypoint.dto.RainyDaysDTO;
import nextoo.exercices.apiweather.externalServices.previsionMeteoService.PrevisionMeteoService;
import nextoo.exercices.apiweather.externalServices.previsionMeteoService.dto.PMSForecastDTO;
import nextoo.exercices.apiweather.utilitaries.ForecastTransformer;
import nextoo.exercices.apiweather.utilitaries.HottestDayTransformer;
import nextoo.exercices.apiweather.utilitaries.RainyDaysTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MainBusiness {

    @Autowired
    PrevisionMeteoService previsionMeteoService;

    public ForecastDTO getForecast(String cityName) {
        Forecast forecast = getForecastEntityByPmsService(cityName);
        return ForecastTransformer.entityToDto(forecast);
    }

    public RainyDaysDTO getRainyDays(String cityName) {
        Forecast forecast = getForecastEntityByPmsService(cityName);
		List<DayForecast> daysForecast = forecast.getDaysForcast();

		List<DayForecast> rainyDaysForecast = daysForecast.stream()
				.filter(DayForecast::isRainy)
				.collect(Collectors.toList());
		return RainyDaysTransformer.entityToDto(rainyDaysForecast);
    }

    public HottestDayDTO getHottestDay(String cityName) {
        Forecast forecast = getForecastEntityByPmsService(cityName);
        List<DayForecast> daysForecast = forecast.getDaysForcast();
        DayForecast hottestDay = daysForecast.stream()
                .max(Comparator.comparing(DayForecast::getMaxTemperature))
                .orElse(null);
        return HottestDayTransformer.entityToDto(hottestDay);
    }

    private Forecast getForecastEntityByPmsService(String cityName) {
        PMSForecastDTO pmsForecastDTO = previsionMeteoService.getForecast(cityName);
        Forecast forecast = ForecastTransformer.pmsDtoToEntity(pmsForecastDTO);
        setAllCalculations(forecast);
        return forecast;
    }
//
//    private void getHumidityAverage(Forecast forecast) {
//        for (DayForecast df : forecast.getDaysForcast()) {
//            df.getHourlyDatas().stream()
//                    .map(HourlyData::getRelativeHumidity)
//                    .filter(Objects::nonNull)
//                    .mapToDouble(Float::doubleValue)
//                    .average()
//                    .ifPresent(avg -> df.setHumidityAverage((float)avg));
//        }
//    }

    // TODO refacto ?

    private void setAllCalculations(Forecast forecast) {
        for (DayForecast df : forecast.getDaysForcast()) {
            df.setAverageData(new Calculations());

            // humidité
            calculateAverage(df,
                    HourlyData::getRelativeHumidity,
                    avg -> df.getAverageData().setAverageRelativeHumidity(avg)
            );

            calculateAverage(df,
                    HourlyData::getAtmosphericPressure,
                    avg -> df.getAverageData().setAverageAtmosphericPressure((float) avg)
            );


            // point de rosée
            df.getHourlyDatas().stream()
                    .map(HourlyData::getDewPoint)
                    .filter(Objects::nonNull)
                    .mapToDouble(Float::doubleValue)
                    .average()
                    .ifPresent(avg -> df.getAverageData().setAverageDewPoint((float)avg));

            // precipitations
            df.getHourlyDatas().stream()
                    .map(HourlyData::getPrecipitation)
                    .filter(Objects::nonNull)
                    .mapToDouble(Float::doubleValue)
                    .average()
                    .ifPresent(avg -> df.getAverageData().setAveragePrecipitation((float)avg));

            // température
            df.getHourlyDatas().stream()
                    .map(HourlyData::getTemp)
                    .filter(Objects::nonNull)
                    .mapToDouble(Float::doubleValue)
                    .average()
                    .ifPresent(avg -> df.getAverageData().setTemperatureAverage((float)avg));

            // refroidissement éolien
            df.getHourlyDatas().stream()
                    .map(HourlyData::getWindChill)
                    .filter(Objects::nonNull)
                    .mapToDouble(Float::doubleValue)
                    .average()
                    .ifPresent(avg -> df.getAverageData().setAverageWindChill((float)avg));

            // vitesse rafale de vent
            df.getHourlyDatas().stream()
                    .map(HourlyData::getWindGustSpeed)
                    .filter(Objects::nonNull)
                    .mapToDouble(Float::doubleValue)
                    .average()
                    .ifPresent(avg -> df.getAverageData().setAverageWindGustSpeed((float)avg));

            // vitesse du vent
            df.getHourlyDatas().stream()
                    .map(HourlyData::getWindSpeed)
                    .filter(Objects::nonNull)
                    .mapToDouble(Float::doubleValue)
                    .average()
                    .ifPresent(avg -> df.getAverageData().setAverageWindSpeed((float)avg));
        }
    }

    private void calculateAverage(DayForecast df, Function<HourlyData, Float> lambdaGetAttribute, DoubleConsumer lambdaSetAttribute) {
        df.getHourlyDatas().stream()
                .map(lambdaGetAttribute)
                .filter(Objects::nonNull)
                .mapToDouble(Float::doubleValue)
                .average()
                .ifPresent(lambdaSetAttribute);
    }

}
