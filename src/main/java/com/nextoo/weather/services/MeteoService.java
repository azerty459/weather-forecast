package com.nextoo.weather.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nextoo.weather.entities.HumiditeSemaine;
import com.nextoo.weather.entities.Meteo;
import com.nextoo.weather.entities.Prevision;
import com.nextoo.weather.entities.PrevisionResponseDTO;
import com.nextoo.weather.entities.TauxHumidite;

@Service
public class MeteoService {
	
	private RestTemplate restTemplate = new RestTemplate();
	//appel vers api pour récupérer datas JSON
	private static final String uri = "https://www.prevision-meteo.ch/services/json/";
	
	
	public PrevisionResponseDTO getPrevisionResponseDTOByVille(String ville) {
		ResponseEntity<PrevisionResponseDTO> villeInfosDTO  = restTemplate.getForEntity(uri+ville, PrevisionResponseDTO.class);
		return villeInfosDTO.getBody();
	}
	
	public Meteo getMeteoByVille(String ville) {
		PrevisionResponseDTO previsionDTO  = getPrevisionResponseDTOByVille(ville);
		Meteo meteo = new Meteo(previsionDTO);
		return meteo;
	}
	
	
	public Prevision getJourLePlusChaud(String ville) {
		PrevisionResponseDTO previsionDTO = getPrevisionResponseDTOByVille(ville);
		List<Prevision> previsionSemaine = previsionDTO.getPrevisionSemaine();
		Prevision jourLePlusChaud = previsionSemaine.stream()
				.max(Comparator.comparing(Prevision::getTemperatureMaximale))
                .orElse(null);

		return jourLePlusChaud;
	}
	
	public List<Prevision> getJoursPluvieux(String ville){
		PrevisionResponseDTO previsionDTO = getPrevisionResponseDTOByVille(ville);
		List<Prevision> previsionSemaine = previsionDTO.getPrevisionSemaine();
		
		List<Prevision> joursPluvieux =  previsionSemaine.stream().filter(prev -> 
				getJourAvecConditionPluie(prev))				
				.collect(Collectors.toList());
		return joursPluvieux;
	}

	private boolean getJourAvecConditionPluie(Prevision prev) {
		return prev.getCondition().toLowerCase().contains("pluie");
	}
	
	public List<Prevision> getJoursPluvieuxPrecipitation(String ville){
		PrevisionResponseDTO previsionDTO = getPrevisionResponseDTOByVille(ville);
		List<Prevision> previsionSemaine = previsionDTO.getPrevisionSemaine();
		
		List<Prevision> joursPluvieux = previsionSemaine.stream()
				.filter(
					prev -> getMoyennePrecipitationParJour(prev)
						>=0.05
				)
				.collect(Collectors.toList());		
		return joursPluvieux;
	}

	private double getMoyennePrecipitationParJour(Prevision prev) {
		return prev.getDonneesParHeure().values().stream()
				.mapToDouble
				(heure -> heure.getPrecipitation())
				.average()
				.getAsDouble();
	}

	
	public TauxHumidite getHumidite(String ville) {
		PrevisionResponseDTO previsionDTO = getPrevisionResponseDTOByVille(ville);
		List<Prevision> previsionSemaine = previsionDTO.getPrevisionSemaine();
		TauxHumidite tauxHumidite = new TauxHumidite();
		tauxHumidite.setHumiditeActuelle(previsionDTO.getConditionActuel().getHumidite());
		
		double moyenneHumiditeSemaine = previsionSemaine.stream()
				.mapToDouble(
						this::getHumiditeMoyenneParJour				
				)
				.average()
				.getAsDouble();
		tauxHumidite.setHumiditeSemaine(moyenneHumiditeSemaine);
		return tauxHumidite;
		
	}
	
	public HumiditeSemaine getHumiditeMoyenneJour(String ville) {
		PrevisionResponseDTO previsionDTO = getPrevisionResponseDTOByVille(ville);
		List<Prevision> previsionSemaine = previsionDTO.getPrevisionSemaine();
		HumiditeSemaine humiditeSemaine = new HumiditeSemaine();
		
		humiditeSemaine.setHumiditeActuelle(previsionDTO.getConditionActuel().getHumidite());
		
		List<Double> moyenneHumiditeSemaine = previsionSemaine.stream()
				.mapToDouble(
				this::getHumiditeMoyenneParJour				
				).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
//				).boxed()
//				.collect(Collectors.toList());
		humiditeSemaine.setHumiditeMoyenneJourSemaine(moyenneHumiditeSemaine);
		return humiditeSemaine;
		
	}

	private double getHumiditeMoyenneParJour(Prevision prev) {
		return prev.getDonneesParHeure()
		.values()
		.stream()
		.mapToDouble(
				heure -> heure.getHumidite())
								.average()
								.getAsDouble();
	}
}
