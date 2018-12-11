package com.nextoo.exercices.weatherforecast.services.impl;

import com.nextoo.exercices.weatherforecast.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TownWeatherService implements WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String WEATHER_URL = "";
}
