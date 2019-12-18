package fr.ia.meteo.meteo.api.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

public class PrevisionHoraireListDTO {

    private HashMap<String, PrevisionHoraireDTO> previsionHoraireList = new HashMap<>();
    private Integer hourOfPrevision =0 ;

    public HashMap<String, PrevisionHoraireDTO> getPrevisionHoraireList() {
        return previsionHoraireList;
    }

    public void setPrevisionHoraireList(HashMap<String, PrevisionHoraireDTO> previsionHoraireList) {
        this.previsionHoraireList = previsionHoraireList;
    }

    @JsonProperty("0H00")
    @JsonAlias({"1H00","2H00","3H00","4H00","5H00","6H00"})
    public void addPrevisionHoraire(PrevisionHoraireDTO previsionHoraireDTO){
        previsionHoraireList.put(hourOfPrevision+"H00", previsionHoraireDTO) ;
        hourOfPrevision++;

    }


    @Override
    public String toString() {
        return "PrevisionHoraireList{" +
                "previsionHoraireList=" + previsionHoraireList +
                ", hourOfPrevision=" + hourOfPrevision +
                '}';
    }
}
