package fr.ia.meteo.meteo.service;

import fr.ia.meteo.meteo.api.ApiService;
import fr.ia.meteo.meteo.job.prevision.Prevision;
import fr.ia.meteo.meteo.job.prevision.PrevisionHoraire;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MeteoService {


    public static List<Prevision> getPrevisionsWithPluie(List<Prevision> listPrevision) {
        return listPrevision.stream()
                .filter(prevision -> prevision.getCondition().contains("Pluie"))
                .collect(Collectors.toList());
    }


    public static Prevision getJourneeHumiditeMini(@PathVariable String nomVille, TreeMap<LocalDate, Double> mapDateHumiditeMoyenne) {
        Double humiditeMin = mapDateHumiditeMoyenne.values().stream().min(Double::compareTo).get();
        LocalDate dateJourHumiditeMin = mapDateHumiditeMoyenne.entrySet().stream().filter(x->x.getValue().equals(humiditeMin)).findFirst().get().getKey();
        List<Prevision> listPrevision = ApiService.getPrevisionsMeteo(nomVille).getPrevisionList();
        return listPrevision.stream()
                .filter(previsionDTO -> previsionDTO.getDate().equals(dateJourHumiditeMin)).findAny().orElse(null);
    }

    public static Double calculerMoyenne(Prevision prevision) {

        List<PrevisionHoraire> PrevisionHoraireList = prevision.getPrevisionHoraireList();
        return PrevisionHoraireList.stream()
                .mapToInt(PrevisionHoraire::getTauxHumidite)
                .average().orElse(0);

    }


    public static TreeMap<LocalDate, Double> getMapHumiditeMoyenne(List<Prevision> listPrevision) {
        HashMap<LocalDate,Double > mapDateHumiditeMoyenne = new HashMap<>();
        List<Double> listhumiditeMoyenne = new ArrayList<>();
        listPrevision.stream()
                .forEach(
                        x -> mapDateHumiditeMoyenne.put(x.getDate(), MeteoService.calculerMoyenne(x) )
                );
        TreeMap<LocalDate,Double> mapSorted = new TreeMap<>();
        mapSorted.putAll(mapDateHumiditeMoyenne);
        return mapSorted;
    }
}
