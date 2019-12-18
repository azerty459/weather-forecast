package fr.ia.meteo.meteo.job;

import fr.ia.meteo.meteo.job.prevision.Prevision;

import java.util.ArrayList;
import java.util.List;

public class Root {


    private List<Prevision> previsionList = new ArrayList<>();
    private ConditionActuelle conditionActuelle;

    public ConditionActuelle getConditionActuelle() {
        return conditionActuelle;
    }

    public void setConditionActuelle(ConditionActuelle conditionActuelle) {
        this.conditionActuelle = conditionActuelle;
    }

    public void addPrevision(Prevision prevision) {
        previsionList.add(prevision);
    }

    public List<Prevision> getPrevisionList() {
        return previsionList;
    }

    public void setPrevisionList(List<Prevision> previsionList) {
        this.previsionList = previsionList;
    }
}
