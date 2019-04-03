package nextoo.weather.dto;

public class HumidityDTO {

    private Double currentHumidity;

    private Double weekAverageHumdity;

    public Double getCurrentHumidity() {
        return currentHumidity;
    }

    public void setCurrentHumidity(Double currentHumidity) {
        this.currentHumidity = currentHumidity;
    }

    public Double getWeekAverageHumdity() {
        return weekAverageHumdity;
    }

    public void setWeekAverageHumdity(Double weekAverageHumdity) {
        this.weekAverageHumdity = weekAverageHumdity;
    }
}
