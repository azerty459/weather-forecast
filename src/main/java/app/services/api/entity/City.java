package app.services.api.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class City {

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

    private Forecast fcst_day_0, fcst_day_1, fcst_day_2, fcst_day_3, fcst_day_4;

    @JsonProperty("erros")
    Collection<Object> errors;

    public City() {
    }

    public Collection<Object> getErrors() {
        return errors;
    }

    public void setErrors(Collection<Object> errors) {
        this.errors = errors;
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

    public Forecast getFcst_day_0() {
        return fcst_day_0;
    }

    public void setFcst_day_0(Forecast fcst_day_0) {
        this.fcst_day_0 = fcst_day_0;
    }

    public Forecast getFcst_day_1() {
        return fcst_day_1;
    }

    public void setFcst_day_1(Forecast fcst_day_1) {
        this.fcst_day_1 = fcst_day_1;
    }

    public Forecast getFcst_day_2() {
        return fcst_day_2;
    }

    public void setFcst_day_2(Forecast fcst_day_2) {
        this.fcst_day_2 = fcst_day_2;
    }

    public Forecast getFcst_day_3() {
        return fcst_day_3;
    }

    public void setFcst_day_3(Forecast fcst_day_3) {
        this.fcst_day_3 = fcst_day_3;
    }

    public Forecast getFcst_day_4() {
        return fcst_day_4;
    }

    public void setFcst_day_4(Forecast fcst_day_4) {
        this.fcst_day_4 = fcst_day_4;
    }


}
