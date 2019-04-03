package app.services.api.dto;

import java.util.ArrayList;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityDTO {

	private String name;

	@JsonProperty("city_info")
	private void nameFromCityInfo(Map<String, String> city_info) {
		name = city_info.get("name");
	}
	
	private Double humidity;
	@JsonProperty("current_condition")
	private void humiFromCurrentCondition(Map<String, String> current_condition) {
		humidity = Double.parseDouble(current_condition.get("humidity"));
	}

	private ForecastDTO fcst_day_0, fcst_day_1, fcst_day_2, fcst_day_3, fcst_day_4;

	public CityDTO() {
	}
	
	

	public Double getHumidity() {
		return humidity;
	}



	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ForecastDTO getFcst_day_0() {
		return fcst_day_0;
	}

	public void setFcst_day_0(ForecastDTO fcst_day_0) {
		this.fcst_day_0 = fcst_day_0;
	}

	public ForecastDTO getFcst_day_1() {
		return fcst_day_1;
	}

	public void setFcst_day_1(ForecastDTO fcst_day_1) {
		this.fcst_day_1 = fcst_day_1;
	}

	public ForecastDTO getFcst_day_2() {
		return fcst_day_2;
	}

	public void setFcst_day_2(ForecastDTO fcst_day_2) {
		this.fcst_day_2 = fcst_day_2;
	}

	public ForecastDTO getFcst_day_3() {
		return fcst_day_3;
	}

	public void setFcst_day_3(ForecastDTO fcst_day_3) {
		this.fcst_day_3 = fcst_day_3;
	}

	public ForecastDTO getFcst_day_4() {
		return fcst_day_4;
	}

	public void setFcst_day_4(ForecastDTO fcst_day_4) {
		this.fcst_day_4 = fcst_day_4;
	}
	
	public ArrayList<ForecastDTO> getPrevisions(){
		ArrayList<ForecastDTO> previsions = new ArrayList<ForecastDTO>();
		previsions.add(fcst_day_0);
		previsions.add(fcst_day_1);
		previsions.add(fcst_day_2);
		previsions.add(fcst_day_3);
		previsions.add(fcst_day_4);
		return previsions;
	}

	public String toString() {
		return "Les prévisions météo pour " + this.name + "\n" + fcst_day_0.toString() + "\n" + fcst_day_1.toString()
				+ "\n" + fcst_day_2.toString() + "\n" + fcst_day_3.toString() + "\n" + fcst_day_4.toString() + "\n";
	}

}
