package com.nextoo.meteo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class City {
	
	private Long id;	
	private String name;
	private Coordinate coord;
	private String country;

}
