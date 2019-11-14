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
public class ForecastWrapper {

	@JsonProperty("cod")
	private Integer code;
	private String message;
	@JsonProperty("list")
	private List<Forecast> forcast;

}
