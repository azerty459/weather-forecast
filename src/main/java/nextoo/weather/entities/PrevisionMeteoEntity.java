package nextoo.weather.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PrevisionMeteoEntity {

    @JsonProperty("city_info")
    private CityEntity city;

    @JsonProperty("current_condition")
    private CurrentMeteoEntity currentMeteo;

    @JsonProperty("fcst_day_0")
    private PrevisionEntity currentDayPrevision;

    @JsonProperty("fcst_day_1")
    private PrevisionEntity oneDayPrevision;

    @JsonProperty("fcst_day_2")
    private PrevisionEntity twoDayPrevision;

    @JsonProperty("fcst_day_3")
    private PrevisionEntity threeDayPrevision;

    @JsonProperty("fcst_day_4")
    private PrevisionEntity fourDayPrevision;

    private List<PrevisionEntity> previsionList;

    public PrevisionMeteoEntity() {
    }

    public PrevisionEntity getOneDayPrevision() {
        return oneDayPrevision;
    }

    public void setOneDayPrevision(PrevisionEntity oneDayPrevision) {
        this.oneDayPrevision = oneDayPrevision;
    }

    public PrevisionEntity getTwoDayPrevision() {
        return twoDayPrevision;
    }

    public void setTwoDayPrevision(PrevisionEntity twoDayPrevision) {
        this.twoDayPrevision = twoDayPrevision;
    }

    public PrevisionEntity getThreeDayPrevision() {
        return threeDayPrevision;
    }

    public void setThreeDayPrevision(PrevisionEntity threeDayPrevision) {
        this.threeDayPrevision = threeDayPrevision;
    }

    public PrevisionEntity getFourDayPrevision() {
        return fourDayPrevision;
    }

    public void setFourDayPrevision(PrevisionEntity fourDayPrevision) {
        this.fourDayPrevision = fourDayPrevision;
    }

    public List<PrevisionEntity> getPrevisionList() {
        List previsionsList = new ArrayList<PrevisionEntity>();
        previsionsList.add(currentDayPrevision);
        previsionsList.add(oneDayPrevision);
        previsionsList.add(twoDayPrevision);
        previsionsList.add(threeDayPrevision);
        previsionsList.add(fourDayPrevision);
        this.previsionList = previsionsList;
        return this.previsionList;
    }

    public void setPrevisionList(List<PrevisionEntity> previsionList) {
        this.previsionList = previsionList;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

    public CurrentMeteoEntity getCurrentMeteo() {
        return currentMeteo;
    }

    public void setCurrentMeteo(CurrentMeteoEntity currentMeteo) {
        this.currentMeteo = currentMeteo;
    }

    public PrevisionEntity getCurrentDayPrevision() {
        return currentDayPrevision;
    }

    public void setCurrentDayPrevision(PrevisionEntity currentDayPrevision) {
        this.currentDayPrevision = currentDayPrevision;
    }

}
