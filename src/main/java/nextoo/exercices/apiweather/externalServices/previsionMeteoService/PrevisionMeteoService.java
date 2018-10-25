package nextoo.exercices.apiweather.externalServices.previsionMeteoService;

import nextoo.exercices.apiweather.externalServices.previsionMeteoService.dto.PMSForecastDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PrevisionMeteoService {

    private static final String URL = "https://www.prevision-meteo.ch/services/json/%s";

    private final RestTemplate restTemplate;

    public PrevisionMeteoService() {
        this.restTemplate = new RestTemplate();
    }

    public PMSForecastDTO getForecast(String cityName) {

        return this.restTemplate.getForObject(
                String.format(URL, cityName),
                PMSForecastDTO.class);
    }

}
