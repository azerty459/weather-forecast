package com.nextoo.meteo.dto;

import java.util.List;

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
public class NextooForecastWrapper {
	
	private String ville;
	
	private NextooForecast actuellement;

	private List<NextooForecast> previsions;

}
