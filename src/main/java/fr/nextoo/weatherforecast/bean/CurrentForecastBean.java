package fr.nextoo.weatherforecast.bean;

import fr.nextoo.weatherforecast.interfaces.City;

public class CurrentForecastBean extends ForecastBean implements City {

	private int id;
	private String name;

	public CurrentForecastBean() {
		super();
	}

	@Override
	public int getCityId() {
		return this.id;
	}
	@Override
	public void setCityId(int id) {
		this.id = id;
	}

	@Override
	public String getCityName() {
		return this.name;
	}
	@Override
	public void setCityName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CurrentForecastBean [id=" + id + ", name=" + name + "]";
	}

}
