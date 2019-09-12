package fr.nextoo.weatherforecast.web.bean;

import java.time.Instant;

public class ForecastBean {

	private Instant instant;
	private double temperature;
	private String weatherName;
	private String weatherDescription;
	private int humidity;
	private double rain;


	public Instant getInstant() {
		return instant;
	}
	public void setInstant(Instant instant) {
		this.instant = instant;
	}

	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public String getWeatherName() {
		return weatherName;
	}
	public void setWeatherName(String weatherName) {
		this.weatherName = weatherName;
	}

	public String getWeatherDescription() {
		return weatherDescription;
	}
	public void setWeatherDescription(String weatherDescription) {
		this.weatherDescription = weatherDescription;
	}

	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public double getRain() {
		return rain;
	}
	public void setRain(double rain) {
		this.rain = rain;
	}

	@Override
	public String toString() {
		return "ForecastBean [instant=" + instant + ", temperature=" + temperature + ", weatherName=" + weatherName
				+ ", weatherDescription=" + weatherDescription + ", humidity=" + humidity + ", rain=" + rain + "]";
	}

}
