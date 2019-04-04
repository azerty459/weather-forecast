package nextoo.exo1.meteorest.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import nextoo.exo1.meteorest.objects.Meteo;
import nextoo.exo1.meteorest.objects.MeteoParHeure;
import nextoo.exo1.meteorest.objects.TraitementJson;

/**
 * @author liam
 */
@Service
public class PrevisionServiceImpl implements PrevisionService {
	
	private static final String URL_SERVICE_METEO = "https://www.prevision-meteo.ch/services/json/";
	
	@Override
	public TraitementJson recuperationJson(String ville) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<TraitementJson> response = restTemplate.getForEntity(URL_SERVICE_METEO + ville, TraitementJson.class);
		return response.getBody();
	}

	@Override
	public Meteo jourLePlusChaud(String ville) {
		TraitementJson e = recuperationJson(ville);
		ArrayList<Meteo> previsions = e.getPrevisions();
		return previsions.stream().max(
				Comparator.comparing(
						Meteo::getTemperatureMax)
				).get();
	}

	@Override
	public Stream<Meteo> jourDePluie(String ville) {
		TraitementJson e = recuperationJson(ville);
		ArrayList<Meteo> previsions = e.getPrevisions();
		return previsions.stream().filter(
				p -> p.getCondition().contains("pluie"));
	}

	@Override
	public Map<String, String> humiditeSemaine(String ville) {
		Map<String, String> map = new HashMap<String, String>();
		TraitementJson e = recuperationJson(ville);
		ArrayList<Meteo> previsions = e.getPrevisions();
		map.put("Current", String.valueOf(e.getCurrent().getHumidite()));
		map.put("Semaine", String.valueOf(
				previsions.stream().mapToDouble(
						p -> getHumiditeMoyenne(p)
						).average().getAsDouble()
				));
		return map;
	}

	private double getHumiditeMoyenne(Meteo p) {
		return p.getParHeure().values().stream().mapToDouble(
				MeteoParHeure::getHumidity
				).average().getAsDouble();
	}

}
