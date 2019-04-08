package nextoo.exo1.meteorest.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PrevisionSemaineDTO {

    @JsonProperty("city_info")
    VilleDTO ville;

    @JsonProperty("current_condition")
    PrevisionJourDTO current;

    @JsonProperty("fcst_day_0")
    PrevisionJourDTO j0;

    @JsonProperty("fcst_day_1")
    PrevisionJourDTO j1;

    @JsonProperty("fcst_day_2")
    PrevisionJourDTO j2;

    @JsonProperty("fcst_day_3")
    PrevisionJourDTO j3;

    /**
     * @return the ville
     */
    public VilleDTO getVille() {
        return ville;
    }

    /**
     * @param ville the ville to set
     */
    public void setVille(VilleDTO ville) {
        this.ville = ville;
    }

    /**
     * @return the current
     */
    public PrevisionJourDTO getCurrent() {
        return current;
    }

    /**
     * @param current the current to set
     */
    public void setCurrent(PrevisionJourDTO current) {
        this.current = current;
    }

    /**
     * @return the j0
     */
    public ArrayList<PrevisionJourDTO> getPrevisions() {
        ArrayList<PrevisionJourDTO> previsions = new ArrayList<PrevisionJourDTO>();
        previsions.add(j0);
        previsions.add(j1);
        previsions.add(j2);
        previsions.add(j3);
        return previsions;
    }

    public PrevisionJourDTO getJ0() {
        return j0;
    }

    public void setJ0(PrevisionJourDTO j0) {
        this.j0 = j0;
    }

    public PrevisionJourDTO getJ1() {
        return j1;
    }

    public void setJ1(PrevisionJourDTO j1) {
        this.j1 = j1;
    }

    public PrevisionJourDTO getJ2() {
        return j2;
    }

    public void setJ2(PrevisionJourDTO j2) {
        this.j2 = j2;
    }

    public PrevisionJourDTO getJ3() {
        return j3;
    }

    public void setJ3(PrevisionJourDTO j3) {
        this.j3 = j3;
    }
}
