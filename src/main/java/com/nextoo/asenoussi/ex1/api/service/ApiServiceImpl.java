package com.nextoo.asenoussi.ex1.api.service;

import com.nextoo.asenoussi.ex1.api.service.entity.ResponseApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiServiceImpl implements ApiService {

	private static final String URL = "http://www.prevision-meteo.ch/services/json/";

	@Autowired
	private RestTemplate restTemplate;

	public ResponseApi getDataFromCityName(String cityName) {
		ResponseEntity<ResponseApi> response
		  = restTemplate.getForEntity(URL + cityName, ResponseApi.class);
        return response.getBody();
	}
}
