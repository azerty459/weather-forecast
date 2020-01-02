package com.example.weather.service;

import model.Day;
import model.Root;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {

    private RestTemplate restTemplate = new RestTemplate();

    public List<Day> getWeather(String city){
         Root result = restTemplate.getForObject("https://www.prevision-meteo.ch/services/json/"+city, Root.class);
         List<Day> days = new ArrayList<>();
         days.add(result.getDay0());
         days.add(result.getDay1());
         days.add(result.getDay2());
        days.add(result.getDay3());
        days.add(result.getDay4());
        return days;
    }
}
