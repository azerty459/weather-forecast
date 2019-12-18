package fr.ia.meteo.meteo.api.dto;

import com.fasterxml.jackson.annotation.*;
import fr.ia.meteo.meteo.job.ConditionActuelle;
import fr.ia.meteo.meteo.job.Ville;

import java.util.ArrayList;
import java.util.List;

public class RootDTO {

    private Ville ville;
    private ConditionActuelle conditionActuelle;
    private List<PrevisionDTO> previsionDTOList = new ArrayList<>();


    @JsonProperty("city_info")
    public void setVille(Ville ville) {
        this.ville = ville;
    }


    @JsonProperty("fcst_day_0")
    @JsonAlias({"fcst_day_1", "fcst_day_2", "fcst_day_3", "fcst_day_4"})
    public void addPrevision(PrevisionDTO previsionDTO) {
        previsionDTOList.add(previsionDTO);

    }

    public Ville getVille() {
        return ville;
    }

    public List<PrevisionDTO> getPrevisionDTOList() {
        return previsionDTOList;
    }

    public void setPrevisionDTOList(List<PrevisionDTO> previsionDTOList) {
        this.previsionDTOList = previsionDTOList;
    }


    public ConditionActuelle getConditionActuelle() {
        return conditionActuelle;
    }

    @JsonProperty("current_condition")
    public void setConditionActuelle(ConditionActuelle conditionActuelle) {
        this.conditionActuelle = conditionActuelle;
    }
}
