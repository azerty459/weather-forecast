package fr.nextoo.weatherforecast.web.bean;

import java.util.List;

public class DaysListForecastsDetailsBean {

	private CityBean city;
	private List<ForecastsDetailsBean> forecastsDetailsList;
	
	public CityBean getCity() {
		return city;
	}
	public void setCity(CityBean city) {
		this.city = city;
	}
	
	public List<ForecastsDetailsBean> getForecastsDetailsList() {
		return forecastsDetailsList;
	}
	public void setForecastsDetailsList(List<ForecastsDetailsBean> forecastsDetailsList) {
		this.forecastsDetailsList = forecastsDetailsList;
	}
	
	@Override
	public String toString() {
		return "DaysListForecastsDetailsBean [city=" + city + ", forecastsDetailsList=" + forecastsDetailsList + "]";
	}

}
