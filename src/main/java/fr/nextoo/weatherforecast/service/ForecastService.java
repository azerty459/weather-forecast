package fr.nextoo.weatherforecast.service;

import fr.nextoo.weatherforecast.dto.ForecastDto;
import fr.nextoo.weatherforecast.dto.MainDto;
import fr.nextoo.weatherforecast.dto.PrevisionDto;

import java.util.List;

public interface ForecastService {

    public ForecastDto getForecastByCity(String nomVille);
    public MainDto getActualHumidity(String ville);
    public PrevisionDto getHotestDayInWeekByCity(String ville);
    public List<String> getRainyDaysByCity(String ville);
}
