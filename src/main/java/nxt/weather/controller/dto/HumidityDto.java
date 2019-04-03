package nxt.weather.controller.dto;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "humidity")
public class HumidityDto {
    
    private int actual;
    private double weekAverage;
    private boolean dry;

    public HumidityDto(int actual, double weekAverage, boolean dry) {
        this.actual = actual;
        this.weekAverage = weekAverage;
        this.dry = dry;
    }

    public int getActual() {
        return actual;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }

    public double getWeekAverage() {
        return weekAverage;
    }

    public void setWeekAverage(double weekAverage) {
        this.weekAverage = weekAverage;
    }

    public boolean isDry() {
        return dry;
    }

    public void setDry(boolean dry) {
        this.dry = dry;
    }
    
}
