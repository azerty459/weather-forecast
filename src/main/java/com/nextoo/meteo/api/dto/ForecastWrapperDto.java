package com.nextoo.meteo.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastWrapperDto {

	@JsonProperty("cod")
	private Integer code;
	private String message;
	@JsonProperty(required = false)
	private ForecastDto actually;
	@JsonProperty("list")
	private List<ForecastDto> forcast;
	
	public ForecastWrapperDto() {
	}
	
	public ForecastWrapperDto(Integer code, String message, ForecastDto actually, List<ForecastDto> forcast) {
		super();
		this.code = code;
		this.message = message;
		this.actually = actually;
		this.forcast = forcast;
	}

	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ForecastDto getActually() {
		return actually;
	}
	public void setActually(ForecastDto actually) {
		this.actually = actually;
	}
	public List<ForecastDto> getForcast() {
		return forcast;
	}
	public void setForcast(List<ForecastDto> forcast) {
		this.forcast = forcast;
	}
	
	

}
