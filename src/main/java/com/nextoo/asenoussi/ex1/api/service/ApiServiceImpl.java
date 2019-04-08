package com.nextoo.asenoussi.ex1.api.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nextoo.asenoussi.ex1.api.service.entity.ResponseApi;

@Service
public class ApiServiceImpl implements ApiService {

	private static final String URL = "http://www.prevision-meteo.ch/services/json/";
	
	public ResponseApi getDataFromCityName(String cityName) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ResponseApi> response
		  = restTemplate.getForEntity(URL + cityName, ResponseApi.class);
        return response.getBody();
	}
}
