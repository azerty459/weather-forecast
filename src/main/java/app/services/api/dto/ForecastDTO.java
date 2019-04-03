package app.services.api.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastDTO {

	private String date;
	private Double tmin;
	private Double tmax;
	private String condition;
	private Map<String, HourDTO> hourly_data;
	
	public ForecastDTO() {
		
	}

	public Map<String, HourDTO> getHourly_data() {
		return hourly_data;
	}


	public void setHourly_data(Map<String, HourDTO> hourly_data) {
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
	
	public String toString() {
		return "Pour le "+date+" la temperature min est de = "+tmin+" et la température max de ="+tmax;
	}
}
