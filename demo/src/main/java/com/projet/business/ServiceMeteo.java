package com.projet.business;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.projet.dto.DayDto;
import com.projet.dto.HottestDay;
import com.projet.dto.Humidity;
import com.projet.dto.PrevisionCityDto;


@Service
public class ServiceMeteo {

	private final static String URL = "http://www.prevision-meteo.ch/services/json/";
	private RestTemplate restTemplate;

	public ServiceMeteo() {
		this.restTemplate = new RestTemplate();	
	}

	/*
	 * Obtenir les infos du jour et de la semaine via une ville donnée
	 * @param une ville donnée
	 */
	public PrevisionCityDto getPrevisionCity(String city){

		PrevisionCityDto p = getResponsePrevisionCity(city);
		
		if(p.getCurrentCondition() == null)
			return null;
		
		return p;
	}


	/*
	 * Obtenir le jour le plus chaud de la semaine via une ville donnée
	 * @param une ville donnée
	 */
	public HottestDay getHottestDay(String city) {

		PrevisionCityDto p = getResponsePrevisionCity(city);
		
		//liste contenant les cinq jours de la semaine
		List<DayDto> list = p.getListOfDays();

		//critére de comparaison pour un jour donné
		Comparator<DayDto> comparator = Comparator.comparing(DayDto::getTempMax);

		//récupération du jour le plus chaud de la semaine avec pour critére de comparaison "comparator"
		DayDto day = list.stream().max(comparator).get();
		
		if(day.getCondition() == null)
			return null;
		
		return new HottestDay(day.getDate(),day.getNameOfDay(),day.getCondition(),day.getTempMax(),day.getTempMin(),day.getIcon());

	}

	/*
	 * Obtenir les jour pluvieux de la semaine via une ville donnée
	 * @param une ville donnée
	 */
	public List<DayDto> getRainyDays(String city) {
		PrevisionCityDto p = getResponsePrevisionCity(city);
		
		if(p.getCurrentCondition() == null)
			return null;

		//liste contenant les cinq jours de la semaine
		List<DayDto> list = p.getListOfDays();

		Stream<DayDto> sp = list.stream();

		//list contenant les jours de la semaine où le mot "pluie" figure
		list = sp.filter(x -> x.getCondition().toLowerCase().contains("pluie"))
				.collect(Collectors.toList());

		return list;
	}


	public Humidity getHumidity(String city) {
		PrevisionCityDto p = getResponsePrevisionCity(city);
		
		if(p.getCurrentCondition() == null)
			return null;
		
		List<DayDto> listOfDays= p.getListOfDays();

		int currentHumidity = p.getCurrentCondition().getHumidity();
		Double moyenne = 0.0;

		//boucle sur chaque jour de la semaine contenu dans liste
		for(DayDto day: listOfDays){

			//on additionne la moyenne de chaque jour de la semaine
			moyenne += day.getHourlyData().entrySet().stream()
					.mapToDouble(x -> x.getValue().getHumidity())
					.average()
					.getAsDouble();
		}		

		//on divise le resultat par le nombre de jour dans la liste
		moyenne /= listOfDays.size();
		//on arrondi au centième
		moyenne = (double)Math.round(moyenne * 100) / 100;

		return new Humidity(currentHumidity, moyenne);
	}
	
	public PrevisionCityDto getResponsePrevisionCity(String city) {
		return restTemplate.getForObject((URL+city), PrevisionCityDto.class);
	}
}
