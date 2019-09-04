package fr.nextoo.weatherforecast.bean;

import java.util.List;

public class ForecastBean {

	private CityBean city;

	private List<WeatherBean> weatherDays;

	public CityBean getCity() {
		return city;
	}

	public void setCity(CityBean city) {
		this.city = city;
	}

	public List<WeatherBean> getWeatherDays() {
		return weatherDays;
	}

	public void setWeatherDays(List<WeatherBean> weatherDays) {
		this.weatherDays = weatherDays;
	}

	@Override
	public String toString() {
		return "ForecastBean [city=" + city + ", weatherDays=" + weatherDays + "]";
	}

}
