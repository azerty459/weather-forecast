package com.projet.dto;

public class HottestDay {

	private String date;
	
	private String day;
	
	private String condition;
	
	private int temperatureMax;
	
	private int temperatureMin;
	
	private String icon;
	
	public HottestDay(String date, String name, String condition, int tempMax, int tempMin, String icon) {
		
		this.date = date;
		this.day = name;
		this.condition = condition;
		this.temperatureMax = tempMax;
		this.temperatureMin = tempMin;
		this.icon =icon;
		this.icon = icon;
	}

	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public int getTemperatureMax() {
		return temperatureMax;
	}


	public void setTemperatureMax(int temperatureMax) {
		this.temperatureMax = temperatureMax;
	}


	public int getTemperatureMin() {
		return temperatureMin;
	}


	public void setTemperatureMin(int temperatureMin) {
		this.temperatureMin = temperatureMin;
	}


	public String getIcon() {
		return icon;
	}


	public void setIcon(String icon) {
		this.icon = icon;
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
