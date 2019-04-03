package nextoo.julien.meteo.services.api;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import nextoo.julien.meteo.services.api.dto.MeteoResponseDto;

@Service
public class MeteoApiServiceImpl implements MeteoApiService {
	
//	@Autowired
//	private RestTemplate restTemplate;
	
	private static final String resourceUrl = "https://www.prevision-meteo.ch/services/json/";

	public MeteoResponseDto getMeteo(String ville) throws IOException {
		
		RestTemplate restTemplate = new RestTemplate();

		MeteoResponseDto meteo = restTemplate.getForObject(resourceUrl + ville, MeteoResponseDto.class);

		return meteo;
	}

}
