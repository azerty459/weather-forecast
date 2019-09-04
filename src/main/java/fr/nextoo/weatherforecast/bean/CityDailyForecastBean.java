package fr.nextoo.weatherforecast.bean;

public class CityDailyForecastBean {

	private CityBean city;
	private DailyForecastBean dailyForecast;
	
	public CityBean getCity() {
		return city;
	}
	public void setCity(CityBean city) {
		this.city = city;
	}
	
	public DailyForecastBean getDailyForecast() {
		return dailyForecast;
	}
	public void setDailyForecast(DailyForecastBean dailyForecast) {
		this.dailyForecast = dailyForecast;
	}
	
	@Override
	public String toString() {
		return "CityDailyForecastBean [city=" + city + ", dailyForecast=" + dailyForecast + "]";
	}
	
}
