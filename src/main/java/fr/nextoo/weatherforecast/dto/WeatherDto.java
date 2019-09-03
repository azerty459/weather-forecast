package fr.nextoo.weatherforecast.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class WeatherDto {
	private int id;
	
    @JsonProperty("name")
	private String city;
    
//	private String sky;
//	private String description;
	
	private double temperature;
	private int pressure;
	private int humidity;
	private double temperatureMin;
	private double temperatureMax;
	
	    @JsonProperty("main")
	    private void unpackNested(Map<String,Object> main) {
	        this.temperature = (double)main.get("temp");
	        this.pressure = (int)main.get("pressure");
	        this.humidity = (int)main.get("humidity");
	        this.temperatureMin = (double)main.get("temp_min");
	        this.temperatureMax = (double)main.get("temp_max");
	    }
//	
	
//	
//	private int visibility;
//	private double windSpeed;
//	private int windDegree;
//	private String clouds;
	
	public WeatherDto() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

//	public String getSky() {
//		return sky;
//	}
//
//	public void setSky(String sky) {
//		this.sky = sky;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public int getPressure() {
		return pressure;
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public double getTemperatureMin() {
		return temperatureMin;
	}

	public void setTemperatureMin(double temperatureMin) {
		this.temperatureMin = temperatureMin;
	}

	public double getTemperatureMax() {
		return temperatureMax;
	}

	public void setTemperatureMax(double temperatureMax) {
		this.temperatureMax = temperatureMax;
	}
//
//	public int getVisibility() {
//		return visibility;
//	}
//
//	public void setVisibility(int visibility) {
//		this.visibility = visibility;
//	}
//
//	public double getWindSpeed() {
//		return windSpeed;
//	}
//
//	public void setWindSpeed(double windSpeed) {
//		this.windSpeed = windSpeed;
//	}
//
//	public int getWindDegree() {
//		return windDegree;
//	}
//
//	public void setWindDegree(int windDegree) {
//		this.windDegree = windDegree;
//	}
//
//	public String getClouds() {
//		return clouds;
//	}
//
//	public void setClouds(String clouds) {
//		this.clouds = clouds;
//	}
//
//	@Override
//	public String toString() {
//		return "WeatherDto [id=" + id + ", city=" + city + ", sky=" + sky + ", description=" + description
//				+ ", temperature=" + temperature + ", pressure=" + pressure + ", humidity=" + humidity
//				+ ", temperatureMin=" + temperatureMin + ", temperatureMax=" + temperatureMax + ", visibility="
//				+ visibility + ", windSpeed=" + windSpeed + ", windDegree=" + windDegree + ", clouds=" + clouds + "]";
//	}

	@Override
	public String toString() {
		return "WeatherDto [id=" + id + ", city=" + city + ", temperature=" + temperature + ", pressure=" + pressure
				+ ", humidity=" + humidity + ", temperatureMin=" + temperatureMin + ", temperatureMax=" + temperatureMax
				+ "]";
	}

	
}
