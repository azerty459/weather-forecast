package fr.ia.meteo.meteo.job.prevision;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

public class PrevisionHoraireList {

    private HashMap<String, PrevisionHoraire> previsionHoraireList = new HashMap<>();
    private Integer hourOfPrevision =0 ;



    public HashMap<String, PrevisionHoraire> getPrevisionHoraireList() {
        return previsionHoraireList;
    }

    public void setPrevisionHoraireList(HashMap<String, PrevisionHoraire> previsionHoraireList) {
        this.previsionHoraireList = previsionHoraireList;
    }

    public void addPrevisionHoraire(PrevisionHoraire previsionHoraire){
        previsionHoraireList.put(hourOfPrevision+"H00", previsionHoraire) ;
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
