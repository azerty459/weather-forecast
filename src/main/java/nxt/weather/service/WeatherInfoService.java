package nxt.weather.service;

import nxt.weather.service.api.WeatherApiService;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.ToDoubleFunction;
import java.util.stream.DoubleStream;
import nxt.weather.controller.dto.ForecastDto;
import nxt.weather.service.api.dto.ForecastDayDto;
import nxt.weather.controller.dto.HumidityDto;
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

    public List<ForecastDto> weather(String city) {
        WeatherDto weather = api.getInformations(city);
        List<ForecastDto> days = new ArrayList<>();

        weather.getForecastDays().forEach(fd -> {
            days.add(new ForecastDto(
                    fd.getDate(),
                    fd.getDay(),
                    fd.getCondition(),
                    fd.getTempMin(),
                    fd.getTempMax()));
        });

        return days;
    }

    public ForecastDto heat(String city) {
        WeatherDto weather = api.getInformations(city); 
        
        ForecastDayDto fd = weather.getForecastDays().stream().max(getComparatorTempMax()).get();
        
        ForecastDto d = new ForecastDto(
                fd.getDate(),
                fd.getDay(),
                fd.getCondition(),
                fd.getTempMin(),
                fd.getTempMax());

        return d;
    }

    private Comparator<ForecastDayDto> getComparatorTempMax() {
        Comparator<ForecastDayDto> comp = Comparator.comparing(ForecastDayDto::getTempMax);
        return comp;
    }

    public List<ForecastDto> rain(String city) {
        WeatherDto weather = api.getInformations(city);
        List<ForecastDto> days = new ArrayList<>();
        
        for (ForecastDayDto fd : weather.getForecastDays()) {
            if (fd.getHourly().entrySet().stream().anyMatch(h -> h.getValue().getCondition().contains("pluie"))) {
                days.add(new ForecastDto(
                        fd.getDate(),
                        fd.getDay(),
                        fd.getCondition(),
                        fd.getTempMin(),
                        fd.getTempMax()));
            }
        }

        return days;
    }

    public HumidityDto humidity(String city) {
        WeatherDto weather = api.getInformations(city);
        
        int actual = weather.getCurrentCondition().getHumidity();
        double avg = getStreamMapToAverageHumidity(weather).average().getAsDouble();
        boolean dry = weather.getForecastDays(0).getHourly().entrySet().stream().mapToDouble(h -> h.getValue().getHumidity()).average().getAsDouble() <= getStreamMapToAverageHumidity(weather).min().getAsDouble();

        return new HumidityDto(actual, avg, dry);
    }

    private DoubleStream getStreamMapToAverageHumidity(WeatherDto weather) {
        return weather.getForecastDays().stream().mapToDouble(getDailyAverageHumidity());
    }

    private ToDoubleFunction<ForecastDayDto> getDailyAverageHumidity() {
        return fd -> fd.getHourly().entrySet().stream().mapToDouble(h -> h.getValue().getHumidity()).average().getAsDouble();
    }

}
