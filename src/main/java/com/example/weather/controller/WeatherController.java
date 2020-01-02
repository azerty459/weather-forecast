package com.example.weather.controller;

import com.example.weather.service.WeatherService;
import model.Day;
import model.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @RequestMapping("/weather")
    public List<Day> getWeather(@RequestParam String city){
        return weatherService.getWeather(city);
    }

    @RequestMapping("/hotestDay")
    public Day hotestDay(@RequestParam String city){
        return weatherService.getHotestDay(city);

    }

    @RequestMapping("/rainyDays")
    public List<Day> rainyDays (@RequestParam String city){
        return weatherService.getRainyDays(city);
    }
}
