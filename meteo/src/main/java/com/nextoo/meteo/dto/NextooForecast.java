package com.nextoo.meteo.dto;

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
public class NextooForecast {

	private String dateEtHeure;
	
	private String temps;

	private Double temperature;

	private Double temperatureMinimum;

	private Double temperatureMaximum;

	private Double pressionAtmospherique;

	private Integer humidite;

}
