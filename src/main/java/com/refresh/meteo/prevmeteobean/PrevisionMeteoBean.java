package com.refresh.meteo.prevmeteobean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrevisionMeteoBean {
    @JsonProperty("city_info")
    private InfoCity infoCity;

    @JsonProperty("fcst_day_0")
    private PrevisionCh jour0;

    @JsonProperty("fcst_day_1")
    private PrevisionCh jour1;

    @JsonProperty("fcst_day_2")
    private PrevisionCh jour2;

    @JsonProperty("fcst_day_3")
    private PrevisionCh jour3;

    @JsonProperty("fcst_day_4")
    private PrevisionCh jour4;

    public InfoCity getCity_info() {
        return infoCity;
    }

    public void setCity_info(InfoCity city_info) {
        this.infoCity = city_info;
    }

    public PrevisionCh getJour0() {
        return jour0;
    }

    public void setJour0(PrevisionCh jour0) {
        this.jour0 = jour0;
    }

    public PrevisionCh getJour1() {
        return jour1;
    }

    public void setJour1(PrevisionCh jour1) {
        this.jour1 = jour1;
    }

    public PrevisionCh getJour2() {
        return jour2;
    }

    public void setJour2(PrevisionCh jour2) {
        this.jour2 = jour2;
    }

    public PrevisionCh getJour3() {
        return jour3;
    }

    public void setJour3(PrevisionCh jour3) {
        this.jour3 = jour3;
    }

    public PrevisionCh getJour4() {
        return jour4;
    }

    public void setJour4(PrevisionCh jour4) {
        this.jour4 = jour4;
    }
}
