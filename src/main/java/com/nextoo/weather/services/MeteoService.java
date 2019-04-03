package com.nextoo.weather.services;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nextoo.weather.entities.DonneesParHeure;
import com.nextoo.weather.entities.DonneesParHeureListe;
import com.nextoo.weather.entities.Meteo;
import com.nextoo.weather.entities.Prevision;
import com.nextoo.weather.entities.PrevisionResponseDTO;

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
		Meteo meteo = new Meteo(previsionDTO);
		Collection<Prevision> previsionSemaine = meteo.getPrevisionSemaine();
		Prevision jourLePlusChaud = previsionSemaine.stream()
				.max(Comparator.comparing(Prevision::getTemperatureMaximale))
                .orElse(null);

		return jourLePlusChaud;
	}
	
	public Collection<Prevision> getJoursPluvieux(String ville){
		PrevisionResponseDTO previsionDTO = getPrevisionResponseDTOByVille(ville);
		Meteo meteo = new Meteo(previsionDTO);
		Collection<Prevision> previsionSemaine = meteo.getPrevisionSemaine();
		Collection<Prevision> joursPluvieux =  previsionSemaine.stream().filter(prev -> 
				(prev.getCondition().toLowerCase().contains("pluie")))				
				.collect(Collectors.toList());
		return joursPluvieux;
	}
	
	public Collection<Prevision> getJoursPluvieux2(String ville){
		PrevisionResponseDTO previsionDTO = getPrevisionResponseDTOByVille(ville);
		Meteo meteo = new Meteo(previsionDTO);
		Collection<Prevision> previsionSemaine = meteo.getPrevisionSemaine();
		
		DonneesParHeureListe donneesJour0 =  ((List<Prevision>) previsionSemaine).get(0).getDonneesParHeure();
		
		return null;
		
	}
	
	
}

//
//DonneesParHeureListe donneesJour1 =  ((List<Prevision>) previsionSemaine).get(1).getDonneesParHeure();
//DonneesParHeureListe donneesJour2 =  ((List<Prevision>) previsionSemaine).get(2).getDonneesParHeure();
//DonneesParHeureListe donneesJour3 =  ((List<Prevision>) previsionSemaine).get(3).getDonneesParHeure();
//DonneesParHeureListe donneesJour4 =  ((List<Prevision>) previsionSemaine).get(4).getDonneesParHeure();
