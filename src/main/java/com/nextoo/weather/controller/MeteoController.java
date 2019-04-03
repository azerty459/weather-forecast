package com.nextoo.weather.controller;

import java.util.Collection;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nextoo.weather.entities.Meteo;
import com.nextoo.weather.entities.Prevision;
import com.nextoo.weather.entities.TauxHumidite;
import com.nextoo.weather.services.MeteoService;

@RestController
public class MeteoController {
	@Autowired
	private MeteoService meteoService;
	
	@RequestMapping(value = "/meteo/{ville}", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
    public Meteo findByVille(@PathVariable("ville") String ville) {
		Meteo meteo = meteoService.getMeteoByVille(ville);
		return meteo;


    }
	
	@RequestMapping(value = "/meteo/{ville}/jourLePlusChaud", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
	public Prevision findByJourLePlusChaud(@PathVariable("ville") String ville) {
		Prevision jourLePlusChaud = meteoService.getJourLePlusChaud(ville);
		return jourLePlusChaud;
	}
	
	@RequestMapping(value = "/meteo/{ville}/joursPluvieux", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
	public Collection<Prevision> findByJoursPluvieux(@PathVariable("ville") String ville) {
		Collection<Prevision> joursPluvieux = meteoService.getJoursPluvieux(ville);
		return joursPluvieux;
	}
	
	@RequestMapping(value = "/meteo/{ville}/joursPluvieuxBis", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
	public Stream<Prevision> findByJoursPluvieuxPrecipitation(@PathVariable("ville") String ville) {
		Stream<Prevision> joursPluvieux = meteoService.getJoursPluvieuxPrecipitation(ville);
		return joursPluvieux;
	}
	
	@RequestMapping(value = "/meteo/{ville}/humidite", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
	public TauxHumidite findByJourTauxHumidite(@PathVariable("ville") String ville) {
		TauxHumidite tauxHumidite = meteoService.getHumidite(ville);
		return tauxHumidite;
	}
	
}
