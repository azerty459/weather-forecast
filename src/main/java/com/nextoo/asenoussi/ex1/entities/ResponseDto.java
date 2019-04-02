package com.nextoo.asenoussi.ex1.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ResponseDto {
	
	@JsonProperty("city_info")
	CityInfoDto cityInfo;
	
	@JsonProperty("fcst_day_0")
	PrevisionDto j0;
	
	@JsonProperty("fcst_day_1")
	PrevisionDto j1;
	
	@JsonProperty("fcst_day_2")
	PrevisionDto j2;
	
	@JsonProperty("fcst_day_3")
	PrevisionDto j3;
	
	List<PrevisionDto> previsions = new ArrayList<>();
	
	@JsonProperty("current_condition")
	CurrentConditionDto currentCondition;

	public CityInfoDto getCityInfo() {
		return cityInfo;
	}

	public void setCityInfo(CityInfoDto cityInfo) {
		this.cityInfo = cityInfo;
	}

	public PrevisionDto getJ0() {
		return j0;
	}

	public void setJ0(PrevisionDto j0) {
		this.j0 = j0;
	}

	public PrevisionDto getJ1() {
		return j1;
	}

	public void setJ1(PrevisionDto j1) {
		this.j1 = j1;
	}

	public PrevisionDto getJ2() {
		return j2;
	}

	public void setJ2(PrevisionDto j2) {
		this.j2 = j2;
	}

	public PrevisionDto getJ3() {
		return j3;
	}

	public void setJ3(PrevisionDto j3) {
		this.j3 = j3;
	}
	
	public Collection<PrevisionDto> getPrevisions(){
		previsions.clear();
		previsions.add(j0);
		previsions.add(j1);
		previsions.add(j2);
		previsions.add(j3);
		return previsions;
	}

	public CurrentConditionDto getCurrentCondition() {
		return currentCondition;
	}

	public void setCurrentCondition(CurrentConditionDto currentCondition) {
		this.currentCondition = currentCondition;
	}
	
	
	
	
}
