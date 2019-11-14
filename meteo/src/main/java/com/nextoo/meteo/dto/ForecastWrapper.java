package com.nextoo.meteo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ForecastWrapper {

	@JsonProperty("cod")
	private Integer code;
	private String message;
	@JsonProperty("cnt")
	private Integer count;
	@JsonProperty("list")
	private List<Forecast> forcast;
	private City city;

}
