package nxt.weather.service.api;

import nxt.weather.service.api.dto.WeatherDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherApiService {
    
    private static final String API_URL = "http://www.prevision-meteo.ch/services/json/";
    
    private final RestTemplate rest = new RestTemplate();
    
    public WeatherDto getInformations(String city) {
        WeatherDto weather = (WeatherDto) this.rest.getForObject(API_URL + city, WeatherDto.class);
        if(weather.getCity() == null) {
            throw new IllegalArgumentException("Ville introuvable");
        }
        return weather;
    }
    
}
