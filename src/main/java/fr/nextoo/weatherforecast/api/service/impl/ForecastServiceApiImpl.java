package fr.nextoo.weatherforecast.api.service.impl;

import fr.nextoo.weatherforecast.api.dto.ForecastApiDto;
import fr.nextoo.weatherforecast.api.service.ForecastServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;

@Service
public class ForecastServiceApiImpl implements ForecastServiceApi {

    @Value("${weather.api.key}")
    private String key;

    private static final String URL = "http://api.openweathermap.org/data/2.5/forecast?q={city}&units=metric&APPID={key}";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ForecastApiDto getForecastByCity(String nomVille) {
        URI url = new UriTemplate(URL).expand(nomVille, key);
        return restTemplate.getForObject(url, ForecastApiDto.class);
    }
}
