package fr.ia.meteo.meteo.api.dto;

import com.fasterxml.jackson.annotation.*;
import fr.ia.meteo.meteo.api.dto.prevision.PrevisionDTO;
import fr.ia.meteo.meteo.entity.Ville;

import java.util.ArrayList;
import java.util.List;

public class RootDTO {

    private Ville ville;
    private ConditionActuelleDTO conditionActuelleDTO;
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


    public ConditionActuelleDTO getConditionActuelleDTO() {
        return conditionActuelleDTO;
    }

    @JsonProperty("current_condition")
    public void setConditionActuelleDTO(ConditionActuelleDTO conditionActuelleDTO) {
        this.conditionActuelleDTO = conditionActuelleDTO;
    }


    @Override
    public String toString() {
        return "RootDTO{" +
                "ville=" + ville +
                ", conditionActuelle=" + conditionActuelleDTO +
                ", previsionDTOList=" + previsionDTOList +
                '}';
    }
}
