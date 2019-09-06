package fr.nextoo.weatherforecast.bean;

import java.time.LocalDate;
import java.util.List;

public class DailyForecastBean {

	private LocalDate day;
	private List<ForecastBean> forecasts;

	public DailyForecastBean() { }

	public DailyForecastBean(LocalDate day, List<ForecastBean> forecasts) {
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
