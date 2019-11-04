package fr.nextoo.weatherforecast.service;

import fr.nextoo.weatherforecast.api.service.WeatherServiceApi;
import fr.nextoo.weatherforecast.dto.ForecastDto;
import org.springframework.beans.factory.annotation.Autowired;

public class WeatherServiceIpml implements WeatherService {

    @Autowired
    public WeatherServiceApi weatherServiceApi;

    @Override
    public ForecastDto getForecastByCity(String nomVille) {
        return null;
    }
}
