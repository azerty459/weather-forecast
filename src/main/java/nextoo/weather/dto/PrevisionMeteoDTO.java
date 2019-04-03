package nextoo.weather.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PrevisionMeteoDTO {

    @JsonProperty("city_info")
    private CityDTO city;

    @JsonProperty("current_condition")
    private CurrentMeteoDTO currentMeteo;

    @JsonProperty("fcst_day_0")
    private PrevisionDTO currentDayPrevision;

    @JsonProperty("fcst_day_1")
    private PrevisionDTO oneDayPrevision;

    @JsonProperty("fcst_day_2")
    private PrevisionDTO twoDayPrevision;

    @JsonProperty("fcst_day_3")
    private PrevisionDTO threeDayPrevision;

    @JsonProperty("fcst_day_4")
    private PrevisionDTO fourDayPrevision;

    private List<PrevisionDTO> previsionList;

    public PrevisionMeteoDTO() {
    }

    public PrevisionDTO getOneDayPrevision() {
        return oneDayPrevision;
    }

    public void setOneDayPrevision(PrevisionDTO oneDayPrevision) {
        this.oneDayPrevision = oneDayPrevision;
    }

    public PrevisionDTO getTwoDayPrevision() {
        return twoDayPrevision;
    }

    public void setTwoDayPrevision(PrevisionDTO twoDayPrevision) {
        this.twoDayPrevision = twoDayPrevision;
    }

    public PrevisionDTO getThreeDayPrevision() {
        return threeDayPrevision;
    }

    public void setThreeDayPrevision(PrevisionDTO threeDayPrevision) {
        this.threeDayPrevision = threeDayPrevision;
    }

    public PrevisionDTO getFourDayPrevision() {
        return fourDayPrevision;
    }

    public void setFourDayPrevision(PrevisionDTO fourDayPrevision) {
        this.fourDayPrevision = fourDayPrevision;
    }

    public List<PrevisionDTO> getPrevisionList() {
        List previsionsList = new ArrayList<PrevisionDTO>();
        previsionsList.add(currentDayPrevision);
        previsionsList.add(oneDayPrevision);
        previsionsList.add(twoDayPrevision);
        previsionsList.add(threeDayPrevision);
        previsionsList.add(fourDayPrevision);
        this.previsionList = previsionsList;
        return this.previsionList;
    }

    public void setPrevisionList(List<PrevisionDTO> previsionList) {
        this.previsionList = previsionList;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

    public CurrentMeteoDTO getCurrentMeteo() {
        return currentMeteo;
    }

    public void setCurrentMeteo(CurrentMeteoDTO currentMeteo) {
        this.currentMeteo = currentMeteo;
    }

    public PrevisionDTO getCurrentDayPrevision() {
        return currentDayPrevision;
    }

    public void setCurrentDayPrevision(PrevisionDTO currentDayPrevision) {
        this.currentDayPrevision = currentDayPrevision;
    }

}
