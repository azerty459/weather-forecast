package app.services.api.impl;

import app.services.api.MeteoService;
import app.services.api.dto.CityDTO;
import app.services.api.dto.ForecastDTO;
import app.services.api.dto.transformer.CityTransformer;
import app.services.api.entity.City;
import app.services.api.entity.Forecast;
import app.services.api.entity.Hour;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class MeteoServiceImpl implements MeteoService {

    @Autowired
    RestTemplate restTemplate;

    private static final String URL = "http://www.prevision-meteo.ch/services/json/";


    @Override
    public CityDTO getCity(String name) {
        City c = restTemplate.getForObject(URL + name, City.class);
        if(c != null && c.getErrors() == null)
            return CityTransformer.entityToDto(c);
        else
            return null;
    }

    @Override
    public String getHottestDay(String name) {
        CityDTO city = getCity(name);

        ForecastDTO Day = city.getForecasts().stream()
                .max(Comparator.comparingDouble(ForecastDTO::getTmax))
                .get();

        return Day.getDate();

    }

    @Override
    public List<ForecastDTO> rainDays(String name) {
        List<ForecastDTO> previsionsRain;
        CityDTO city = getCity(name);

        previsionsRain = city.getForecasts().stream()
                .filter(this::hasPreci)
                .collect(Collectors.toList());

        return previsionsRain;
    }

    @Override
    public Pair<Double, Double> avgHumi(String name) {
        CityDTO city = getCity(name);

        Double currentHumidity = city.getHumidity();

        Double avgHumidityForNextDays = city.getForecasts().stream()
                .mapToDouble(this::avgHumiPerDay)
                .average()
                .getAsDouble();

        return new Pair<>(currentHumidity, avgHumidityForNextDays);
    }

    private double avgHumiPerDay(ForecastDTO day) {
        return day.getHourly_data().values()
                .stream()
                .mapToDouble(Hour::getRH2m)
                .average().getAsDouble();
    }

    private boolean hasPreci(ForecastDTO day) {
        return day.getHourly_data().values()
                .stream()
                .mapToDouble(Hour::getAPCPsfc).filter(c -> c > 0)
                .count() > 0;
    }

}
