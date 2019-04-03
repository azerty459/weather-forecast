package com.nextoo.weather.entities;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrevisionResponseDTO {

	@JsonProperty("city_info")
	VilleInfos villeInfos;
	
	@JsonProperty("current_condition")
	ConditionActuel conditionActuel;
	
	@JsonProperty("fcst_day_0")
	Prevision previsionJour0;

	
	@JsonProperty("fcst_day_1")
	Prevision previsionJour1;
	
	@JsonProperty("fcst_day_2")
	Prevision previsionJour2;
	

	@JsonProperty("fcst_day_3")
	Prevision previsionJour3;
	

	@JsonProperty("fcst_day_4")
	Prevision previsionJour4;


	public VilleInfos getVilleInfos() {
		return villeInfos;
	}


	public void setVilleInfos(VilleInfos villeInfos) {
		this.villeInfos = villeInfos;
	}


	public ConditionActuel getConditionActuel() {
		return conditionActuel;
	}


	public void setConditionActuel(ConditionActuel conditionActuel) {
		this.conditionActuel = conditionActuel;
	}


	public Prevision getPrevisionJour0() {
		return previsionJour0;
	}


	public void setPrevisionJour0(Prevision previsionJour0) {
		this.previsionJour0 = previsionJour0;
	}


	public Prevision getPrevisionJour1() {
		return previsionJour1;
	}


	public void setPrevisionJour1(Prevision previsionJour1) {
		this.previsionJour1 = previsionJour1;
	}


	public Prevision getPrevisionJour2() {
		return previsionJour2;
	}


	public void setPrevisionJour2(Prevision previsionJour2) {
		this.previsionJour2 = previsionJour2;
	}


	public Prevision getPrevisionJour3() {
		return previsionJour3;
	}


	public void setPrevisionJour3(Prevision previsionJour3) {
		this.previsionJour3 = previsionJour3;
	}


	public Prevision getPrevisionJour4() {
		return previsionJour4;
	}


	public void setPrevisionJour4(Prevision previsionJour4) {
		this.previsionJour4 = previsionJour4;
	}
	
}
