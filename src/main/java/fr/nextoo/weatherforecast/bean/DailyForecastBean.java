package fr.nextoo.weatherforecast.bean;

import java.util.Date;
import java.util.List;

public class DailyForecastBean {
	
	private Date date;
	private List<ForecastBean> forecasts;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
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
