package fr.nextoo.weatherforecast.bean;

import java.time.Instant;
import java.util.List;

public class DailyForecastBean {
	
	private Instant date;
	private List<ForecastBean> forecasts;
	
	public Instant getDate() {
		return date;
	}
	public void setDate(Instant date) {
		this.date = date;
	}
	
	public List<ForecastBean> getForecasts() {
		return forecasts;
	}
	public void setForecasts(List<ForecastBean> forecasts) {
		this.forecasts = forecasts;
	}
	
	@Override
	public String toString() {
		return "Day [date=" + date + ", forecasts=" + forecasts + "]";
	}
	
}
