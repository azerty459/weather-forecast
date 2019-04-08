package app.services.api;

import java.util.List;

import app.services.api.dto.CityDTO;
import app.services.api.dto.ForecastDTO;
import app.services.api.entity.City;
import app.services.api.entity.Forecast;
import javafx.util.Pair;

public interface MeteoService {
	
	public CityDTO getCity(String name);
	
	public String getHottestDay(String name);
	
	public List<ForecastDTO> rainDays(String name);
	
	public Pair<Double, Double> avgHumi(String name);
}
