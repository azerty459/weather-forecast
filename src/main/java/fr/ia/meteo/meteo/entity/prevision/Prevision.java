package fr.ia.meteo.meteo.entity.prevision;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Prevision implements Comparable<Prevision> {

    private LocalDate date;
    private Integer tempMin;
    private Integer tempMax;
    private String condition;
    private List<PrevisionHoraire> previsionHoraireList;


    public void setDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        this.date = LocalDate.parse(date, formatter);
    }

    @JsonIgnore
    public String getDateString() {
        return date.toString();
    }

    public LocalDate getDate() {
        return date;
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

    public List<PrevisionHoraire> getPrevisionHoraireList() {
        return previsionHoraireList;
    }

    public void setPrevisionHoraireList(List<PrevisionHoraire> previsionHoraireList) {
        this.previsionHoraireList = previsionHoraireList;
    }

    @Override
    public int compareTo(Prevision o) {
        return this.getDate().compareTo(o.getDate());
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
