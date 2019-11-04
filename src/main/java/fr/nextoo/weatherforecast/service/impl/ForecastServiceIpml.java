package fr.nextoo.weatherforecast.service.impl;

import fr.nextoo.weatherforecast.api.service.ForecastServiceApi;
import fr.nextoo.weatherforecast.dto.ForecastDto;
import fr.nextoo.weatherforecast.service.ForecastService;
import fr.nextoo.weatherforecast.service.util.MappingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForecastServiceIpml implements ForecastService {

    @Autowired
    public ForecastServiceApi forecastServiceApi;
    @Autowired
    public MappingUtility mappingUtility;

    @Override
    public ForecastDto getForecastByCity(String nomVille) {
        return mappingUtility.getMappedForecastData(forecastServiceApi.getForecastByCity(nomVille));
    }
}
