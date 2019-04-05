package nextoo.exo1.meteorest.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import nextoo.exo1.meteorest.entites.PrevisionSemaine;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import nextoo.exo1.meteorest.entites.PrevisionJour;
import nextoo.exo1.meteorest.entites.PrevisionHeure;

/**
 * @author liam
 */
@Service
public class MeteoServiceImpl implements IMeteoService {
	
	private static final String URL_SERVICE_METEO = "https://www.prevision-meteo.ch/services/json/";

	@Override
	public PrevisionSemaine recuperationJson(String ville) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<PrevisionSemaine> response = restTemplate.getForEntity(URL_SERVICE_METEO + ville, PrevisionSemaine.class);
		return response.getBody();
	}

	@Override
	public PrevisionJour jourLePlusChaud(String ville) {
		PrevisionSemaine e = recuperationJson(ville);
		ArrayList<PrevisionJour> previsions = e.getPrevisions();
		return previsions.stream().max(
				Comparator.comparing(
						PrevisionJour::getTemperatureMax)
				).get();
	}

	@Override
	public Stream<PrevisionJour> jourDePluie(String ville) {
		PrevisionSemaine e = recuperationJson(ville);
		ArrayList<PrevisionJour> previsions = e.getPrevisions();
		return previsions.stream().filter(
				p -> p.getCondition().contains("pluie"));
	}

	@Override
	public Map<String, String> humiditeSemaine(String ville) {
		Map<String, String> map = new HashMap<String, String>();
		PrevisionSemaine e = recuperationJson(ville);
		ArrayList<PrevisionJour> previsions = e.getPrevisions();
		map.put("Current", String.valueOf(e.getCurrent().getHumidite()));
		map.put("Semaine", String.valueOf(
				previsions.stream().mapToDouble(
						p -> getHumiditeMoyenne(p))
						.average().orElse(0)
				));
		return map;
	}

	private double getHumiditeMoyenne(PrevisionJour p) {
		return p.getParHeure().values().stream().mapToDouble(
				PrevisionHeure::getHumidity
				).average().orElse(0);
	}

}
