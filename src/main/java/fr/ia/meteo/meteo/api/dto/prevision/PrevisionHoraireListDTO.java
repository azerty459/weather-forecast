package fr.ia.meteo.meteo.api.dto.prevision;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class PrevisionHoraireListDTO {

    private List<PrevisionHoraireDTO> previsionHoraireList = new ArrayList<>();
    private Integer hourOfPrevision =0 ;



    @JsonProperty("0H00")
    @JsonAlias({"1H00","2H00","3H00","4H00","5H00","6H00"})
    public void addPrevisionHoraire(PrevisionHoraireDTO previsionHoraireDTO){
        previsionHoraireDTO.setHeurePrevisionHoraire(hourOfPrevision);
        previsionHoraireList.add( previsionHoraireDTO) ;
        hourOfPrevision++;

    }


    public List<PrevisionHoraireDTO> getPrevisionHoraireList() {
        return previsionHoraireList;
    }

    public void setPrevisionHoraireList(List<PrevisionHoraireDTO> previsionHoraireList) {
        this.previsionHoraireList = previsionHoraireList;
    }

    public Integer getHourOfPrevision() {
        return hourOfPrevision;
    }

    public void setHourOfPrevision(Integer hourOfPrevision) {
        this.hourOfPrevision = hourOfPrevision;
    }

    @Override
    public String toString() {
        return "PrevisionHoraireList{" +
                "previsionHoraireList=" + previsionHoraireList +
                ", hourOfPrevision=" + hourOfPrevision +
                '}';
    }
}
