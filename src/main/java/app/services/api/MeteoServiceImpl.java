package app.services.api;

import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import app.services.api.dto.*;
import javafx.util.Pair;

@Service
public class MeteoServiceImpl implements MeteoService {
	
	@Autowired
	RestTemplate restTemplate;
	
	private static final String URL = "http://www.prevision-meteo.ch/services/json/";
	@Override
	public CityDTO getCity(String name) {
	     CityDTO city = restTemplate.getForObject(URL+name, CityDTO.class);
	     return city;
	}

	@Override
	public String getHottestDay(String name) {
		CityDTO city = restTemplate.getForObject(URL+name, CityDTO.class);
		
		ForecastDTO Day = city.getPrevisions().stream()
				.max(Comparator.comparingDouble(ForecastDTO::getTmax))
				.get();
							
		return Day.getDate();
		
	}

	@Override
	public ForecastDTO[] rainDays(String name) {
		ForecastDTO[] previsionsRain;
		CityDTO city = restTemplate.getForObject(URL+name, CityDTO.class);
		
		previsionsRain = city.getPrevisions().stream()
				.filter(c -> c.getCondition().toLowerCase().contains("pluie")).toArray(ForecastDTO[]::new);
							
		return previsionsRain;
	}

	@Override
	public Pair<Double, Double> avgHumi(String name) {
		CityDTO city = restTemplate.getForObject(URL+name, CityDTO.class);
			
		Double currentHumidity = city.getHumidity(); 
		
		
		Double avgHumidityForNextDays = city.getPrevisions().stream()
				.mapToDouble(
						x -> x.getHourly_data().values()
						.stream()
						.mapToDouble(hour -> hour.getRH2m())
						.average().getAsDouble()
						)
				.average()
				.getAsDouble();
				
		return new Pair<Double, Double>(currentHumidity, avgHumidityForNextDays);		
	}
		
}
