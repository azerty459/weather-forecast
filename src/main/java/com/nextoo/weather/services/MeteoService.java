package com.nextoo.weather.services;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
				(prev.getCondition().toLowerCase().contains("pluie")))				
				.collect(Collectors.toList());
		return joursPluvieux;
	}
	
	public Stream<Prevision> getJoursPluvieuxPrecipitation(String ville){
		PrevisionResponseDTO previsionDTO = getPrevisionResponseDTOByVille(ville);
		List<Prevision> previsionSemaine = previsionDTO.getPrevisionSemaine();
		
		Stream<Prevision> joursPluvieux = previsionSemaine.stream().filter(
					prev -> (prev.getDonneesParHeure().values().stream()
							.mapToDouble
							(heure -> heure.getPrecipitation()).average().getAsDouble())
						>=0.05
				);		
		return joursPluvieux;
	}

	
	public TauxHumidite getHumidite(String ville) {
		PrevisionResponseDTO previsionDTO = getPrevisionResponseDTOByVille(ville);
		List<Prevision> previsionSemaine = previsionDTO.getPrevisionSemaine();
		TauxHumidite tauxHumidite = new TauxHumidite();
		tauxHumidite.setHumiditeActuelle(previsionDTO.getConditionActuel().getHumidite());
		
		double moyenneHumiditeSemaine = previsionSemaine.stream().mapToDouble(
				prev -> prev.getDonneesParHeure().values().stream().mapToDouble(
						heure -> heure.getHumidite()).average().getAsDouble()				
				).average().getAsDouble();
		tauxHumidite.setHumiditeSemaine(moyenneHumiditeSemaine);
		return tauxHumidite;
		
	}
}
