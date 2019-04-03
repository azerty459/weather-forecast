package nextoo.weather.services.api;

import nextoo.weather.entities.PrevisionMeteoEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PrevisionMeteoApiService {

    private static final String meteoUrl = "http://www.prevision-meteo.ch/services/json/";

    public PrevisionMeteoEntity findCityPrevision(String name){
        RestTemplate restTemplate = new RestTemplate();
        PrevisionMeteoEntity response = restTemplate.getForObject(meteoUrl + name, PrevisionMeteoEntity.class);
        return response;
    }

}
