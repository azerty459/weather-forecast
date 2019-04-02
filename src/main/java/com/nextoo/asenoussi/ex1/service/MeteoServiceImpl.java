package com.nextoo.asenoussi.ex1.service;

import java.util.Comparator;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nextoo.asenoussi.ex1.entities.HumidityResponseDto;
import com.nextoo.asenoussi.ex1.entities.PrevisionDto;
import com.nextoo.asenoussi.ex1.entities.ResponseDto;

@Service
public class MeteoServiceImpl implements MeteoService{
	
	private static final String URL = "http://www.prevision-meteo.ch/services/json/";
	
	public ResponseDto getDataFromCityName(String cityName) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ResponseDto> response
		  = restTemplate.getForEntity(URL + cityName, ResponseDto.class);
        return response.getBody();
	}
	
	@Override
	public PrevisionDto getMostHotDayOfWeek(String cityName) {
		ResponseDto response = getDataFromCityName(cityName);
/*		Prevision prevision = response.getPrevisions().stream().max( 
				(Prevision p1, Prevision p2) -> 
				Double.compare(p1.getTemperatureMoyenne(), p2.getTemperatureMoyenne())
		).get();*/
		
		PrevisionDto prevision = response.getPrevisions().stream().max(
				Comparator.comparingDouble(PrevisionDto::getTemperatureMoyenne)
		).get();
		
		
		return prevision;
	}
	
	public PrevisionDto[] getDayWithRain(String cityName){
		ResponseDto response = getDataFromCityName(cityName);
		PrevisionDto[] previsions = response.getPrevisions().stream().filter(
				(p) -> (p.getCondition().toLowerCase().contains("pluie")
		)).toArray(PrevisionDto[]::new);
		return previsions;
	}
	
	public HumidityResponseDto humidity(String cityName) {
		ResponseDto response = getDataFromCityName(cityName);
		HumidityResponseDto humidityResponse = new HumidityResponseDto();
		
		humidityResponse.setCurrentHumidity(response.getCurrentCondition().getHumidity());
		
		
		
		Double humidityAvg = response.getPrevisions().stream().mapToDouble(
				
				p -> p.getHourlyData().values().stream().mapToDouble(
						hourly -> hourly.getHumidity()
				).average().getAsDouble()
				
		).average().getAsDouble();
		
		humidityResponse.setWeekAvgHumidity(humidityAvg);
		return humidityResponse;
	}
	
}
