package nextoo.exercices.apiweather.externalServices.previsionMeteoService.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PMSForecastDTO {

    @JsonSetter("current_condition")
    private PMSCurrentConditionDTO currentCondition;

    @JsonSetter("fcst_day_0")
    private PMSDayForecastDTO today;

    @JsonSetter("fcst_day_1")
    private PMSDayForecastDTO tomorrow;

    @JsonSetter("fcst_day_2")
    private PMSDayForecastDTO inTwoDays;

    @JsonSetter("fcst_day_3")
    private PMSDayForecastDTO inThreeDays;

    @JsonSetter("fcst_day_4")
    private PMSDayForecastDTO inFourDays;

    public PMSForecastDTO() {
    }

    public PMSCurrentConditionDTO getCurrentCondition() {
        return currentCondition;
    }

    public void setCurrentCondition(PMSCurrentConditionDTO currentCondition) {
        this.currentCondition = currentCondition;
    }

    public PMSDayForecastDTO getToday() {
        return today;
    }

    public void setToday(PMSDayForecastDTO today) {
        this.today = today;
    }

    public PMSDayForecastDTO getTomorrow() {
        return tomorrow;
    }

    public void setTomorrow(PMSDayForecastDTO tomorrow) {
        this.tomorrow = tomorrow;
    }

    public PMSDayForecastDTO getInTwoDays() {
        return inTwoDays;
    }

    public void setInTwoDays(PMSDayForecastDTO inTwoDays) {
        this.inTwoDays = inTwoDays;
    }

    public PMSDayForecastDTO getInThreeDays() {
        return inThreeDays;
    }

    public void setInThreeDays(PMSDayForecastDTO inThreeDays) {
        this.inThreeDays = inThreeDays;
    }

    public PMSDayForecastDTO getInFourDays() {
        return inFourDays;
    }

    public void setInFourDays(PMSDayForecastDTO inFourDays) {
        this.inFourDays = inFourDays;
    }

}
