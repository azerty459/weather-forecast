package fr.nextoo.weatherforecast.bean;

public class WeatherBean {
	private int id;
	private String city;
	private double temperature;
	private int pressure;
	private int humidity;
	private double temperatureMin;
	private double temperatureMax;
	
	public WeatherBean() {
	}
	
	public WeatherBean(int id, String city) {
		this.id = id;
		this.city = city;
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

	@Override
	public String toString() {
		return "WeatherBean [id=" + id + ", city=" + city + ", temperature=" + temperature + ", pressure=" + pressure
				+ ", humidity=" + humidity + ", temperatureMin=" + temperatureMin + ", temperatureMax=" + temperatureMax
				+ "]";
	}


}
