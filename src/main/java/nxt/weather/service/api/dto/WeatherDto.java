package nxt.weather.service.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class WeatherDto {
    
    private final CityDto city;
    private final ConditionDto currentCondition;
    private final List<ForecastDayDto> forecastDays = new ArrayList<>();
    
    /*
    Indique à Jackson d'utiliser ce constructeur (et non celui par defaut) pour
    la construction de l'objet. Les @JsonProperty indique à quel parametre
    correspond chaque propriété.
    */
    @JsonCreator
    public WeatherDto(
      @JsonProperty("city_info") CityDto city_info, 
      @JsonProperty("current_condition") ConditionDto current_condition,
      @JsonProperty("fcst_day_0") ForecastDayDto fcst_day_0,
      @JsonProperty("fcst_day_1") ForecastDayDto fcst_day_1,
      @JsonProperty("fcst_day_2") ForecastDayDto fcst_day_2,
      @JsonProperty("fcst_day_3") ForecastDayDto fcst_day_3,
      @JsonProperty("fcst_day_4") ForecastDayDto fcst_day_4) {
        this.city = city_info;
        this.currentCondition =  current_condition;
        this.forecastDays.add(fcst_day_0);
        this.forecastDays.add(fcst_day_1);
        this.forecastDays.add(fcst_day_2);
        this.forecastDays.add(fcst_day_3);
        this.forecastDays.add(fcst_day_4);
    }

    public CityDto getCity() {
        return city;
    }

    public ConditionDto getCurrentCondition() {
        return currentCondition;
    }

    public List<ForecastDayDto> getForecastDays() {
        return forecastDays;
    }
    
    public ForecastDayDto getForecastDays(int index) {
        if(index < 0 || index >= forecastDays.size()) {
            return null;
        }
        return forecastDays.get(index);
    }
    
}
