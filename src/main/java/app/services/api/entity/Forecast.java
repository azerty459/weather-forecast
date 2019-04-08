package app.services.api.entity;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {

	private String date;
	private Double tmin;
	private Double tmax;
	private String condition;
	private Map<String, Hour> hourly_data;

	public Map<String, Hour> getHourly_data() {
		return hourly_data;
	}

	public void setHourly_data(Map<String, Hour> hourly_data) {
		this.hourly_data = hourly_data;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getTmin() {
		return tmin;
	}

	public void setTmin(Double tmin) {
		this.tmin = tmin;
	}

	public Double getTmax() {
		return tmax;
	}

	public void setTmax(Double tmax) {
		this.tmax = tmax;
	}

}
