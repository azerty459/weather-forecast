package nextoo.julien.meteo.services.api;

import java.io.IOException;
import java.text.Normalizer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import nextoo.julien.meteo.services.api.dto.MeteoDto;

@Service
public class MeteoApiServiceImpl implements MeteoApiService {

//	@Autowired
	private RestTemplate restTemplate = getRestTemplate();
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	private static final String RESSOURCE_URL = "https://www.prevision-meteo.ch/services/json/";

	public MeteoDto getMeteo(String ville) throws IOException {
		
		//String villeRecherche = ville.replaceAll(" ", "-").replaceAll("'", "-");

		//RestTemplate restTemplate = new RestTemplate();
		
		String villeRecherche = getNomVilleNormalise(ville);

		MeteoDto meteo = restTemplate.getForObject(RESSOURCE_URL + villeRecherche, MeteoDto.class);

		return meteo;
	}
	
	public static String getNomVilleNormalise(String ville) {
		
		String vr = ville.replaceAll(" ", "-").replaceAll("'", "-");
		
		  return Normalizer.normalize(vr, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
	}

}
