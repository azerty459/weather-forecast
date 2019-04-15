package nxt.weather.service;

import nxt.weather.controller.dto.HourlyDto;
import nxt.weather.service.api.WeatherApiService;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.DoubleStream;
import nxt.weather.controller.dto.ForecastDto;
import nxt.weather.service.api.dto.ForecastDayDto;
import nxt.weather.controller.dto.HumidityDto;
import nxt.weather.controller.dto.ReturnDto;
import nxt.weather.exception.WeatherCityNotFoundException;
import nxt.weather.service.api.dto.HourlyDataDto;
import nxt.weather.service.api.dto.WeatherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service s'occupant de récupèrer les infos d'une api météo et analyse pour
 * répondre au demande d'un controller
 * @author Arthur Brandao
 */
@Service
public class WeatherInfoService {
    
    @Autowired
    private WeatherApiService api;

    public ReturnDto<List<ForecastDto>> weather(String city) {
        WeatherDto weather;
        try {
            weather = api.getInformations(city);
        } catch(WeatherCityNotFoundException ex) {
            return new ReturnDto<>(404, ex.getMessage());
        }
        List<ForecastDto> days = new ArrayList<>();

        weather.getForecastDays().forEach(fd -> {
            //Création liste données horaire
            HourlyDto[] hourly = new HourlyDto[fd.getHourly().size()];
            fd.getHourly().forEach((key, value) -> {
                hourly[Integer.parseInt(key.split("H")[0])] = new HourlyDto(
                        value.getHumidity(),
                        value.getPrecipitation(),
                        value.getTemperature());
            });
            days.add(new ForecastDto(
                    fd.getDate(),
                    fd.getDay(),
                    fd.getCondition(),
                    fd.getTempMin(),
                    fd.getTempMax(),
                    fd.getIcon(),
                    hourly));
        });


        return new ReturnDto<>(days);
    }

    public ReturnDto<ForecastDto> heat(String city) {
        WeatherDto weather;
        try {
            weather = api.getInformations(city);
        } catch(WeatherCityNotFoundException ex) {
            return new ReturnDto<>(404, ex.getMessage());
        }
        
        ForecastDayDto fd = weather.getForecastDays().stream().max(getComparatorTempMax()).get();
        
        ForecastDto forecast = new ForecastDto(
                fd.getDate(),
                fd.getDay(),
                fd.getCondition(),
                fd.getTempMin(),
                fd.getTempMax(),
                fd.getIcon());

        return new ReturnDto<>(forecast);
    }

    private Comparator<ForecastDayDto> getComparatorTempMax() {
        return Comparator.comparing(ForecastDayDto::getTempMax);
    }

    public ReturnDto<List<ForecastDto>> rain(String city) {
        WeatherDto weather;
        try {
            weather = api.getInformations(city);
        } catch(WeatherCityNotFoundException ex) {
            return new ReturnDto<>(404, ex.getMessage());
        }
        List<ForecastDto> days = new ArrayList<>();
        
        weather.getForecastDays().stream().filter((fd) -> (fd.getHourly().entrySet().stream().anyMatch(h -> h.getValue().getPrecipitation() > 0))).forEachOrdered((fd) -> {
            days.add(new ForecastDto(
                    fd.getDate(),
                    fd.getDay(),
                    fd.getCondition(),
                    fd.getTempMin(),
                    fd.getTempMax(),
                    fd.getIcon()));
        });

        return new ReturnDto<>(days);
    }

    public ReturnDto<HumidityDto> humidity(String city) {
        WeatherDto weather;
        try {
            weather = api.getInformations(city);
        } catch(WeatherCityNotFoundException ex) {
            return new ReturnDto<>(404, ex.getMessage());
        }
        
        int actual = weather.getCurrentCondition().getHumidity();
        double avg = getStreamMapToAverageHumidity(weather).average().getAsDouble();
        boolean dry = weather.getForecastDays(0).getHourly().entrySet().stream().mapToDouble(this::getHumidityFromMap).average().getAsDouble() <= getStreamMapToAverageHumidity(weather).min().getAsDouble();

        return new ReturnDto<>(new HumidityDto(actual, avg, dry));
    }

    private DoubleStream getStreamMapToAverageHumidity(WeatherDto weather) {
        return weather.getForecastDays().stream().mapToDouble(this::getDailyAverageHumidity);
    }

    private double getDailyAverageHumidity(ForecastDayDto fd) {
        return fd.getHourly().entrySet().stream().mapToDouble(this::getHumidityFromMap).average().getAsDouble();
    }

    private int getHumidityFromMap(Entry<String, HourlyDataDto> mapHourly) {
        return mapHourly.getValue().getHumidity();
    }

}
