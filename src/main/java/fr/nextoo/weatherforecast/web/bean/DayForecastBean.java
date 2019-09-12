package fr.nextoo.weatherforecast.web.bean;

public class DayForecastBean extends ForecastBean {

	private CityBean city;

	public CityBean getCity() {
		return city;
	}

	public void setCity(CityBean city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "DayForecastBean [city=" + city + ", instant=" + getInstant() + ", temperature="
				+ getTemperature() + ", weatherName=" + getWeatherName() + ", weatherDescription="
				+ getWeatherDescription() + ", humidity=" + getHumidity() + ", rain=" + getRain() + "]";
	}
	
}
