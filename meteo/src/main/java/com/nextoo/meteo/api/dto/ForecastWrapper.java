package com.nextoo.meteo.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastWrapper {

	@JsonProperty("cod")
	private Integer code;
	private String message;
	@JsonProperty(required = false)
	private Forecast actually;
	@JsonProperty("list")
	private List<Forecast> forcast;
	
	public ForecastWrapper() {
	}
	
	public ForecastWrapper(Integer code, String message, Forecast actually, List<Forecast> forcast) {
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
	public Forecast getActually() {
		return actually;
	}
	public void setActually(Forecast actually) {
		this.actually = actually;
	}
	public List<Forecast> getForcast() {
		return forcast;
	}
	public void setForcast(List<Forecast> forcast) {
		this.forcast = forcast;
	}
	
	

}
