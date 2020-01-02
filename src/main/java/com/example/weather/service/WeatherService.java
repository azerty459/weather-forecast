package com.example.weather.service;

import model.Day;
import model.Root;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherService {

    private RestTemplate restTemplate = new RestTemplate();

    private static final String RAIN = "Pluie";

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

    public Day getHotestDay(String city){
        List<Day> days = getWeather(city);
        Day day = days.stream().max(Comparator.comparingInt(Day::getTempMax)).get();
        return day;
    }

    public List<Day> getRainyDays(String city){
        List<Day> days = getWeather(city);
        List<Day>  rainyDays = days.stream().filter(d -> d.getCondition().contains(RAIN)).
                collect(Collectors.toList());
        return rainyDays;
    }
}
