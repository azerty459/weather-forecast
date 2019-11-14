package com.nextoo.meteo.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {

	@JsonProperty("main")
	private WeatherInfo weatherInfo;

	private List<Weather> weather;

	@JsonProperty("dt_txt")
	private String datetime;

}
