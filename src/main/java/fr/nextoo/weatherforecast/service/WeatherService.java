package fr.nextoo.weatherforecast.service;

public interface WeatherService<T> {

    public T getWeatherByCity(String ville);
}
