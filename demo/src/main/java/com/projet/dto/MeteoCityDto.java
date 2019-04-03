package com.projet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class MeteoCityDto { 

	@JsonProperty("city_info")
	private CityInfoDto cityInfo;
	
	@JsonProperty("forecast_info")
	private ForecastInfoDto forecastInfo;
	
	@JsonProperty("current_condition")
	private CurrentConditionDto currentCondition;

	@JsonProperty("fcst_day_0")
	private FcstDayDto fcstDay0;
	
	@JsonProperty("fcst_day_1")
	private FcstDayDto fcstDay1;
	
	@JsonProperty("fcst_day_2")
	private FcstDayDto fcstDay2;
	
	@JsonProperty("fcst_day_3")
	private FcstDayDto fcstDay3;
	
	@JsonProperty("fcst_day_4")
	private FcstDayDto fcstDay4;
	

	public void setFcstDay4(FcstDayDto fcstDay4) {
		this.fcstDay4 = fcstDay4;
	}

	public CityInfoDto getCityInfo() {
		return cityInfo;
	}
	
	public void setCityInfo(CityInfoDto cityInfo) {
		this.cityInfo = cityInfo;
	}
	
	public ForecastInfoDto getForecastInfo() {
		return forecastInfo;
	}
	
	public void setForecastInfo(ForecastInfoDto forecastInfo) {
		this.forecastInfo = forecastInfo;
	}
	
	public CurrentConditionDto getCurrentCondition() {
		return currentCondition;
	}
	
	public void setCurrentCondition(CurrentConditionDto currentCondition) {
		this.currentCondition = currentCondition;
	}
	
	public FcstDayDto getFcstDay0() {
		return fcstDay0;
	}

	public void setFcstDay0(FcstDayDto fcstDay0) {
		this.fcstDay0 = fcstDay0;
	}

	public FcstDayDto getFcstDay1() {
		return fcstDay1;
	}

	public void setFcstDay1(FcstDayDto fcstDay1) {
		this.fcstDay1 = fcstDay1;
	}

	public FcstDayDto getFcstDay2() {
		return fcstDay2;
	}

	public void setFcstDay2(FcstDayDto fcstDay2) {
		this.fcstDay2 = fcstDay2;
	}

	public FcstDayDto getFcstDay3() {
		return fcstDay3;
	}

	public void setFcstDay3(FcstDayDto fcstDay3) {
		this.fcstDay3 = fcstDay3;
	}

	public FcstDayDto getFcstDay4() {
		return fcstDay4;
	}
	







}
