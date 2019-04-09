package com.nextoo.asenoussi.ex1.api.service.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ResponseApi {
	
	@JsonProperty("city_info")
	private CityInfo cityInfo;
	
	@JsonProperty("fcst_day_0")
	private Forecast forecastJ0;
	
	@JsonProperty("fcst_day_1")
	private Forecast forecastJ1;
	
	@JsonProperty("fcst_day_2")
	private Forecast forecastJ2;
	
	@JsonProperty("fcst_day_3")
	private Forecast forecastJ3;
	
	@JsonProperty("fcst_day_4")
	private Forecast forecastJ4;
	
	@JsonProperty("current_condition")
	private CurrentCondition currentCondition;
	
	@JsonProperty("errors")
	private Collection<Object> errors;

	public CityInfo getCityInfo() {return cityInfo;}

	public void setCityInfo(CityInfo cityInfo) {this.cityInfo = cityInfo;}

	public CurrentCondition getCurrentCondition() {return currentCondition;}

	public void setCurrentCondition(CurrentCondition currentCondition) {this.currentCondition = currentCondition;}

	public Forecast getForecastJ0() {return forecastJ0;}

	public void setForecastJ0(Forecast forecastJ0) {this.forecastJ0 = forecastJ0;}

	public Forecast getForecastJ1() {return forecastJ1;}

	public void setForecastJ1(Forecast forecastJ1) {this.forecastJ1 = forecastJ1;}

	public Forecast getForecastJ2() {return forecastJ2;}

	public void setForecastJ2(Forecast forecastJ2) {this.forecastJ2 = forecastJ2;}

	public Forecast getForecastJ3() {return forecastJ3;}

	public void setForecastJ3(Forecast forecastJ3) {this.forecastJ3 = forecastJ3;}

	public Collection<Object> getErrors() {return errors;}

	public void setErrors(Collection<Object> errors) {this.errors = errors;}

	public Forecast getForecastJ4() {return forecastJ4;}

	public void setForecastJ4(Forecast forecastJ4) {this.forecastJ4 = forecastJ4;}
}
