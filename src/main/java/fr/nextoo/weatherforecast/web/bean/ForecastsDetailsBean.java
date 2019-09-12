package fr.nextoo.weatherforecast.web.bean;

import java.time.LocalDate;
import java.util.List;

public class ForecastsDetailsBean {

	private LocalDate day;
	private List<ForecastBean> forecasts;

	public ForecastsDetailsBean() { }

	public ForecastsDetailsBean(LocalDate day, List<ForecastBean> forecasts) {
		this.day = day;
		this.forecasts = forecasts;
	}

	public LocalDate getDay() {
		return day;
	}
	public void setDay(LocalDate day) {
		this.day = day;
	}

	public List<ForecastBean> getForecasts() {
		return forecasts;
	}
	public void setForecasts(List<ForecastBean> forecasts) {
		this.forecasts = forecasts;
	}

	@Override
	public String toString() {
		return "DailyForecastBean [day=" + day + ", forecasts=" + forecasts + "]";
	}

}
