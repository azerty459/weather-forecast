package com.projet.dto;

public class HottestDay {

	private String date;
	
	private String day;
	
	private String condition;
	
	private int temperatureMax;
	
	public HottestDay(String date, String name, String condition, int tempMax) {
		
		this.date = date;
		this.day = name;
		this.condition = condition;
		this.temperatureMax = tempMax;
	}


	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return day;
	}

	public void setName(String name) {
		this.day = name;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	public int getTempMax() {
		return temperatureMax;
	}
	
	public void setTempMax(int tempMax) {
		this.temperatureMax = tempMax;
	}

}
