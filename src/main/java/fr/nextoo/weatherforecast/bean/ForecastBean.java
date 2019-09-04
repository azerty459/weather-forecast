package fr.nextoo.weatherforecast.bean;

public class ForecastBean {

	private double temperature;
	private String weatherName;
	private String weatherDescription;
	private int humidity;
	private double rain;
	private int clouds;
	private double windSpeed;
	private double windDirection;
	private double snow;
	
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
	
	public int getClouds() {
		return clouds;
	}
	public void setClouds(int clouds) {
		this.clouds = clouds;
	}
	
	public double getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}
	
	public double getWindDirection() {
		return windDirection;
	}
	public void setWindDirection(double windDirection) {
		this.windDirection = windDirection;
	}
	
	public double getSnow() {
		return snow;
	}
	public void setSnow(double snow) {
		this.snow = snow;
	}
	
	@Override
	public String toString() {
		return "ForecastBean [temperature=" + temperature + ", weatherName=" + weatherName + ", weatherDescription="
				+ weatherDescription + ", humidity=" + humidity + ", rain=" + rain + ", clouds=" + clouds
				+ ", windSpeed=" + windSpeed + ", windDirection=" + windDirection + ", snow=" + snow + "]";
	}
	
}
