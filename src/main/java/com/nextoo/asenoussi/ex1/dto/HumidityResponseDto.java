package com.nextoo.asenoussi.ex1.dto;

public class HumidityResponseDto {
	
	private int currentHumidity;

	private double weekAvgHumidity;

	public int getCurrentHumidity() {
		return currentHumidity;
	}

	public void setCurrentHumidity(int currentHumidity) {
		this.currentHumidity = currentHumidity;
	}

	public double getWeekAvgHumidity() {
		return weekAvgHumidity;
	}

	public void setWeekAvgHumidity(double weekAvgHumidity) {
		this.weekAvgHumidity = weekAvgHumidity;
	}
	
	
}
