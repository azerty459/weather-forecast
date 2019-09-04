package fr.nextoo.weatherforecast.bean;

public class AtmosphereBean {

	private double temperature;

	private double temperatureMin;

	private double temperatureMax;

	private double pressure;

	private int humidity;

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
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

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	@Override
	public String toString() {
		return "AtmosphereBean [temperature=" + temperature + ", temperatureMin=" + temperatureMin + ", temperatureMax="
				+ temperatureMax + ", pressure=" + pressure + ", humidity=" + humidity + "]";
	}

}
