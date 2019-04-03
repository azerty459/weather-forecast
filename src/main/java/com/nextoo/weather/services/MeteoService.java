package com.nextoo.weather.services;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
		Collection<Prevision> joursPluvieux =  previsionSemaine.stream().filter(Prevision::estPluvieux)
				.collect(Collectors.toList());
		return joursPluvieux;
	}
	
//	public Meteo getMeteoByVille(String ville) {		
//		PrevisionResponseDTO villeInfosDTO  = restTemplate.getForObject(uri+ville, PrevisionResponseDTO.class);
//		PrevisionResponseDTO conditionActuelDTO = restTemplate.getForObject(uri+ville, PrevisionResponseDTO.class);
//		PrevisionResponseDTO previsionJour0DTO = restTemplate.getForObject(uri+ville, PrevisionResponseDTO.class);		
//		PrevisionResponseDTO previsionJour1DTO = restTemplate.getForObject(uri+ville, PrevisionResponseDTO.class);		
//		PrevisionResponseDTO previsionJour2DTO = restTemplate.getForObject(uri+ville, PrevisionResponseDTO.class);		
//		PrevisionResponseDTO previsionJour3DTO = restTemplate.getForObject(uri+ville, PrevisionResponseDTO.class);	
//		PrevisionResponseDTO previsionJour4DTO = restTemplate.getForObject(uri+ville, PrevisionResponseDTO.class);
//		
//
//		VilleInfos villeInfos = villeInfosDTO.getVilleInfos();		
//		ConditionActuel conditionActuel = conditionActuelDTO.getConditionActuel();		
//		Prevision previsionJour0 = previsionJour0DTO.getPrevisionJour0();		
//		Prevision previsionJour1 = previsionJour1DTO.getPrevisionJour1();		
//		Prevision previsionJour2 = previsionJour2DTO.getPrevisionJour2();		
//		Prevision previsionJour3 = previsionJour3DTO.getPrevisionJour3();		
//		Prevision previsionJour4 = previsionJour4DTO.getPrevisionJour4();
//		
//		
//		
//		Meteo meteo = new Meteo();
//		meteo.setVilleInfos(villeInfos);
//		meteo.setConditionActuel(conditionActuel);
//		meteo.setPrevisionJour0(previsionJour0);
//		meteo.setPrevisionJour1(previsionJour1);
//		meteo.setPrevisionJour2(previsionJour2);
//		meteo.setPrevisionJour3(previsionJour3);
//		meteo.setPrevisionJour4(previsionJour4);
//		
//		return meteo;
//	}
	

	
	
}

