package nxt.weather.service.api.dto;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import java.util.LinkedList;
import java.util.List;

public class HourlyDto {
    
    List<HourlyDataDto> data = new LinkedList<>();
    
    /*
    Indique a Jackson d'utiliser cette méthode pourset toutes les valeurs de
    l'objet, permet de construire par exemple une map
    */
    @JsonAnySetter
    public void setHourlyData(String name, HourlyDataDto value) {
        this.data.add(value);
    }
    
    public HourlyDataDto get(int hour) {
        return this.data.get(hour);
    }
    
    public List<HourlyDataDto> getAll() {
        return this.data;
    }
    
}
