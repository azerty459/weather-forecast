package fr.nextoo.weatherforecast.service;

import fr.nextoo.weatherforecast.dto.ForecastDto;
import fr.nextoo.weatherforecast.dto.MainDto;

public interface ForecastService {

    public ForecastDto getForecastByCity(String nomVille);
}
