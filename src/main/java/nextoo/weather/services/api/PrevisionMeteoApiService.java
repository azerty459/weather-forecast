package nextoo.weather.services.api;

import nextoo.weather.dto.PrevisionMeteoDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PrevisionMeteoApiService {

    private static final String meteoUrl = "http://www.prevision-meteo.ch/services/json/";

    public PrevisionMeteoDTO findCityPrevision(String name){
        RestTemplate restTemplate = new RestTemplate();
        PrevisionMeteoDTO response = restTemplate.getForObject(meteoUrl + name, PrevisionMeteoDTO.class);
        return response;
    }

}
