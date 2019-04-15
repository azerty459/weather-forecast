package nxt.weather.service.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
Indique à Jackson d'ignorer les propriété non prise en charge par la class
Si absent alors erreur lors du parse
Possible aussi de mettre @JsonIgnoreProperties({"prop"}) pour juste ignorer
la propriete "prop"
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConditionDto {
    
    private String date;
    private String hour;
    private int temp;
    private int windSpeed;
    private String windDir;
    private double pressure;
    private int humidity;
    private String condition;
    private String conditionKey;
    private String icon;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getTemp() {
        return temp;
    }

    /*
    Indique à JackSon d'utiliser ce setter pour deserialiser le json pour
    l'attribut "tmp"
    */
    @JsonProperty("tmp")
    public void setTemp(int tmp) {
        this.temp = tmp;
    }
    
    public int getWindSpeed() {
        return windSpeed;
    }

    @JsonProperty("wnd_spd")
    public void setWindSpeed(int wnd_spd) {
        this.windSpeed = wnd_spd;
    }

    public String getWindDir() {
        return windDir;
    }

    @JsonProperty("wnd_dir")
    public void setWindDir(String wnd_dir) {
        this.windDir = wnd_dir;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getConditionKey() {
        return conditionKey;
    }

    @JsonProperty("condition_key")
    public void setConditionLey(String condition_key) {
        this.conditionKey = condition_key;
    }

    public String getIcon() {
        return icon;
    }

    @JsonProperty("icon_big")
    public void setIcon(String icon) {
        this.icon = icon;
    }
}
