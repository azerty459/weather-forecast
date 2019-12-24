package fr.ia.meteo.meteo.service;

import fr.ia.meteo.meteo.api.ApiService;
import fr.ia.meteo.meteo.entity.Root;
import fr.ia.meteo.meteo.entity.prevision.Prevision;
import fr.ia.meteo.meteo.entity.prevision.PrevisionHoraire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/***
 * fournit des services utilisés par le MeteoController
 */

@Service
public class MeteoService {

    @Autowired
    private ApiService apiService;

    public List<Prevision> getPrevisionsWithPluie(String nomVille) {
        List<Prevision> listPrevision = apiService.getPrevisionsMeteo(nomVille).getPrevisionList();
        return getPrevisionsWithPluie(listPrevision);
    }

    /***
     * Filtre la liste des prévisions pour obtenir les journées de pluie
     * @param listPrevision
     * @return liste des prévisions contenant pluie
     */
    public static List<Prevision> getPrevisionsWithPluie(List<Prevision> listPrevision) {
        return listPrevision.stream()
                .filter(prevision -> prevision.getCondition().contains("Pluie"))
                .collect(Collectors.toList());
    }


    public Prevision getJourneeHumiditeMini(@PathVariable String nomVille) {
        List<Prevision> listPrevision = apiService.getPrevisionsMeteo(nomVille).getPrevisionList();
        Map<LocalDate, Double> mapDateHumiditeMoyenne = getMapHumiditeMoyenne(nomVille);
        Double humiditeMin = mapDateHumiditeMoyenne.values().stream()
                .min(Double::compareTo)
                .orElse(null);
        Map.Entry<LocalDate, Double> jourMin = mapDateHumiditeMoyenne.
                entrySet()
                .stream()
                .min(Comparator.comparing(Map.Entry::getValue))
                .orElse(null);
        return listPrevision.stream()
                .filter(previsionDTO -> {
                    assert jourMin != null;
                    return previsionDTO.getDate().equals(jourMin.getKey());
                })
                .findAny()
                .orElse(null);
    }

    /***
     * Fournit l'humidité moyenne de la liste de prévisions horaires
     * @param prevision
     * @return humidité moyenne
     */
    public Double calculerMoyenne(Prevision prevision) {

        List<PrevisionHoraire> PrevisionHoraireList = prevision.getPrevisionHoraireList();
        return PrevisionHoraireList.stream()
                .mapToInt(PrevisionHoraire::getTauxHumidite)
                .average()
                .orElse(0);
    }

    /***
     * fournit une map contenant date et humidite moyenne pour une liste de prévisions
     * @param nomVille
     * @return
     */
    public Map<LocalDate, Double> getMapHumiditeMoyenne(String nomVille) {
        List<Prevision> listPrevision = apiService.getPrevisionsMeteo(nomVille).getPrevisionList();
        SortedMap<LocalDate, Double> mapDateHumiditeMoyenne = new TreeMap<>();
        listPrevision
                .forEach(
                        x -> mapDateHumiditeMoyenne.put(x.getDate(), calculerMoyenne(x))
                );
        return mapDateHumiditeMoyenne;
    }

    public Prevision getJourneePlusChaud(String nomVille) {
        Root listPrevision = apiService.getPrevisionsMeteo(nomVille);
        Prevision previsionJourTempMax = listPrevision.getPrevisionList()
                .stream()
                .max(Comparator.comparing(Prevision::getTempMax))
                .orElse(null);
        return previsionJourTempMax;
    }
}
