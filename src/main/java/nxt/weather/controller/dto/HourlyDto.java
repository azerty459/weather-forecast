package nxt.weather.controller.dto;

public class HourlyDto {

    private int humidity;
    private double precipitation;
    private double temperature;

    public HourlyDto(int humidity, double precipitation, double temperature) {
        this.humidity = humidity;
        this.precipitation = precipitation;
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
