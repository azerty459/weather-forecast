package fr.nextoo.weatherforecast.web.bean;

public class DaysListForecastsDetailsBean {

	private CityBean city;
	private ForecastsDetailsBean dailyForecast;
	
	public CityBean getCity() {
		return city;
	}
	public void setCity(CityBean city) {
		this.city = city;
	}
	
	public ForecastsDetailsBean getDailyForecast() {
		return dailyForecast;
	}
	public void setDailyForecast(ForecastsDetailsBean dailyForecast) {
		this.dailyForecast = dailyForecast;
	}
	
	@Override
	public String toString() {
		return "CityDailyForecastBean [city=" + city + ", dailyForecast=" + dailyForecast + "]";
	}
	
}
