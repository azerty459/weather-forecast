package com.refresh.meteo.bean;

import com.refresh.meteo.prevmeteobean.PrevisionCh;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Prevision {
    private List<String> conditionsPluvieuses = new ArrayList<>();

    private Date jour;
    private Integer temperatureMin;
    private Integer temperatureMax;
    private Boolean pluvieux;

    public Prevision(PrevisionCh prevCh) {
        initConditionsPluvieuses();
        try{
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
            this.jour = df.parse(prevCh.getDate().replace(".","/"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.temperatureMin = prevCh.getTmin();
        this.temperatureMax = prevCh.getTmax();
        this.pluvieux = conditionsPluvieuses.contains(prevCh.getCondition());
    }

    private void initConditionsPluvieuses() {
        this.conditionsPluvieuses.add("Averses de pluie modérée");
        this.conditionsPluvieuses.add("Averses de pluie forte");
        this.conditionsPluvieuses.add("Averses de pluie faible");
        this.conditionsPluvieuses.add("Couvert avec averses");
        this.conditionsPluvieuses.add("Pluie faible");
        this.conditionsPluvieuses.add("Pluie forte");
        this.conditionsPluvieuses.add("Pluie modérée");
    }

    public Date getJour() {
        return jour;
    }

    public void setJour(Date jour) {
        this.jour = jour;
    }

    public Integer getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(Integer temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public Integer getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(Integer temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public Boolean getPluvieux() {
        return pluvieux;
    }

    public void setPluvieux(Boolean pluvieux) {
        this.pluvieux = pluvieux;
    }
}
