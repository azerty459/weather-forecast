package com.nextoo.meteo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({ "id", "icon" })
public class Weather {
	
	@JsonProperty("main")
	private String title;
	
	private String description;

}
