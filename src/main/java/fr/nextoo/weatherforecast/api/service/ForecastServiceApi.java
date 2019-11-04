package fr.nextoo.weatherforecast.api.service;

import fr.nextoo.weatherforecast.api.dto.ForecastApiDto;

public interface ForecastServiceApi<T> {

    public ForecastApiDto getForecastByCity(String nomVille);
}
