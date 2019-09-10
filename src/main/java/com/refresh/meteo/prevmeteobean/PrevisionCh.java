package com.refresh.meteo.prevmeteobean;

import java.util.Date;

public class PrevisionCh {
    private String date;
    private Integer tmin;
    private Integer tmax;
    private String condition;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getTmin() {
        return tmin;
    }

    public void setTmin(Integer tmin) {
        this.tmin = tmin;
    }

    public Integer getTmax() {
        return tmax;
    }

    public void setTmax(Integer tmax) {
        this.tmax = tmax;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
