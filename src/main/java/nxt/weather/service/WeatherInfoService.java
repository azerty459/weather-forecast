package nxt.weather.service;

import nxt.weather.service.api.WeatherApiService;
import java.util.ArrayList;
import java.util.List;
import nxt.weather.controller.dto.ForecastDto;
import nxt.weather.service.api.dto.ForecastDayDto;
import nxt.weather.controller.dto.HumidityDto;
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

        for (ForecastDayDto fd : weather.getForecastDays()) {
            days.add(new ForecastDto(
                    fd.getDate(),
                    fd.getDay(),
                    fd.getCondition(),
                    fd.getTempMin(),
                    fd.getTempMax()));
        }

        return days;
    }

    public ForecastDto heat(String city) {
        WeatherDto weather = api.getInformations(city);
        
        int max = 0;
        int index = 0;
        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                max = weather.getForecastDays(i).getTempMax();
                index = i;
            } else if (weather.getForecastDays(i).getTempMax() > max) {
                max = weather.getForecastDays(i).getTempMax();
                index = i;
            }
        }
        ForecastDto d = new ForecastDto(
                weather.getForecastDays(index).getDate(),
                weather.getForecastDays(index).getDay(),
                weather.getForecastDays(index).getCondition(),
                weather.getForecastDays(index).getTempMin(),
                weather.getForecastDays(index).getTempMax());

        return d;
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
        boolean dry = true;
        double avg = 0;
        int nb = 0;
        for (ForecastDayDto fd : weather.getForecastDays()) {
            double avgDay = fd.getHourly().entrySet().stream().mapToInt(h -> h.getValue().getHumidity()).sum();
            nb += fd.getHourly().size();
            avg = avg + (1 / (nb + 1.0)) * (avgDay - avg);
            if(dry && actual > avgDay) {
                dry = false;
            }
        }

        return new HumidityDto(actual, avg, dry);
    }

}
