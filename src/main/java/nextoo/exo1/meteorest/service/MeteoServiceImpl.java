package nextoo.exo1.meteorest.service;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

import nextoo.exo1.meteorest.controller.dto.PrevisionHeureDTO;
import nextoo.exo1.meteorest.controller.dto.PrevisionJourDTO;
import nextoo.exo1.meteorest.controller.dto.PrevisionSemaineDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author liam
 */
@Service
public class MeteoServiceImpl implements IMeteoService {
	
	private static final String URL_SERVICE_METEO = "https://www.prevision-meteo.ch/services/json/";

	@Override
	public PrevisionSemaineDTO appelApiMeteo(String ville) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<PrevisionSemaineDTO> response = restTemplate.getForEntity(URL_SERVICE_METEO + ville, PrevisionSemaineDTO.class);
		return response.getBody();
	}

	@Override
	public PrevisionJourDTO jourLePlusChaud(String ville) {
		PrevisionSemaineDTO e = appelApiMeteo(ville);
		ArrayList<PrevisionJourDTO> previsions = e.getPrevisions();
		return previsions.stream().max(
				Comparator.comparing(
						PrevisionJourDTO::getTemperatureMax)
				).get();
	}

	@Override
	public List<PrevisionJourDTO> jourDePluie(String ville) {
		PrevisionSemaineDTO e = appelApiMeteo(ville);
		ArrayList<PrevisionJourDTO> previsions = e.getPrevisions();
		return previsions.stream().filter(
				p -> p.getCondition().contains("pluie")).collect(Collectors.toList());
	}

	@Override
	public Map<String, String> humiditeSemaine(String ville) {
		Map<String, String> map = new HashMap<String, String>();
		PrevisionSemaineDTO e = appelApiMeteo(ville);
		ArrayList<PrevisionJourDTO> previsions = e.getPrevisions();
		map.put("Current", String.valueOf(e.getCurrent().getHumidite()));
		map.put("Semaine", String.valueOf(
				previsions.stream().mapToDouble(
						p -> getHumiditeMoyenne(p))
						.average().orElse(0)
				));
		return map;
	}

	private double getHumiditeMoyenne(PrevisionJourDTO p) {
		return p.getParHeure().values().stream().mapToDouble(
				PrevisionHeureDTO::getHumidity
				).average().orElse(0);
	}

}
