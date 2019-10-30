package fr.nextoo.weatherforecast.service.impl;

import fr.nextoo.weatherforecast.api.ResponseApi;
import fr.nextoo.weatherforecast.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Value("${weather.api.key}")
    private String key;

    private static final String URL = "http://api.openweathermap.org/data/2.5/forecast?q={city}&APPID={key}";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseApi getWeatherByCity(String ville) {
        URI url = new UriTemplate(URL).expand(ville, key);
        return restTemplate.getForObject(url, ResponseApi.class);
    }
}
