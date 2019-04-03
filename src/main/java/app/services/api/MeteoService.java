package app.services.api;

import app.services.api.dto.*;
import javafx.util.Pair;

public interface MeteoService {
	
	public CityDTO getCity(String name);
	
	public String getHottestDay(String name);
	
	public ForecastDTO[] rainDays(String name);
	
	public Pair<Double, Double> avgHumi(String name);
}
