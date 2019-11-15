package com.nextoo.meteo.dto;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NextooHumidityForecast {

	private String ville;
	private Integer humiditeActuelle;
	private Map<String, Double> humiditeMoyen;
	private List<NextooForecast> lePluSec;

}
