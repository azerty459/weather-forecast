package fr.ia.meteo.meteo.job.prevision;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Prevision {

    private LocalDate date;

    private Integer tempMin;

    private Integer tempMax;

    private String condition;

    private HashMap<String, PrevisionHoraire> previsionHoraireList ;



    public void setDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        this.date = LocalDate.parse(date, formatter);
    }


    public String getDate() {
        return date.toString();
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Integer getTempMin() {
        return tempMin;
    }

    public void setTempMin(Integer tempMin) {
        this.tempMin = tempMin;
    }

    public Integer getTempMax() {
        return tempMax;
    }

    public void setTempMax(Integer tempMax) {
        this.tempMax = tempMax;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public HashMap<String, PrevisionHoraire> getPrevisionHoraireList() {
        return previsionHoraireList;
    }

    public void setPrevisionHoraireList(HashMap<String, PrevisionHoraire> previsionHoraireList) {
        this.previsionHoraireList = previsionHoraireList;
    }

    @Override
    public String toString() {
        return "Prevision{" +
                "date=" + date +
                ", tempMin=" + tempMin +
                ", tempMax=" + tempMax +
                ", condition='" + condition + '\'' +
                ", previsionHoraireList=" + previsionHoraireList +
                '}';
    }
}
