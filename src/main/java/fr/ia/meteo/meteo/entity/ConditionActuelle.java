package fr.ia.meteo.meteo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConditionActuelle {


    @JsonProperty("date")
    private LocalDate date;
    private Integer temp;
    private Integer tauxHumidite;
    private String condition;


    public LocalDate getDate() {
        return date;
    }

    public void setDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        this.date = LocalDate.parse(date, formatter);
    }

    public Integer getTemp() {
        return temp;
    }


    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    public Integer getTauxHumidite() {
        return tauxHumidite;
    }

    public void setTauxHumidite(Integer tauxHumidite) {
        this.tauxHumidite = tauxHumidite;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
