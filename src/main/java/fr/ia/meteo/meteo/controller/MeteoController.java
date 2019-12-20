package fr.ia.meteo.meteo.controller;

import fr.ia.meteo.meteo.job.ConditionActuelle;
import fr.ia.meteo.meteo.job.Root;
import fr.ia.meteo.meteo.api.ApiService;
import fr.ia.meteo.meteo.job.prevision.Prevision;
import fr.ia.meteo.meteo.service.MeteoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping(value = "/previsions")
public class MeteoController {


    @GetMapping(value = "{nomVille}")
    @ApiOperation("Retourne la liste des prévisions de la ville")
    public Root getAllPrevisions(@PathVariable String nomVille) {

        Root response = ApiService.getPrevisionsMeteo(nomVille);
        return  response;

    }


    @GetMapping(value = "{nomVille}/jourpluschaud")
    public Prevision getJourPlusChaud(@PathVariable String nomVille) {

        Root listPrevision = ApiService.getPrevisionsMeteo(nomVille);
        Prevision previsionJourTempMax = listPrevision.getPrevisionList().stream()
                .max(Comparator.comparing(Prevision::getTempMax)).get();

        return previsionJourTempMax;

    }


    @GetMapping(value = "{nomVille}/avecpluie")
    public List<Prevision> getListJourWithPluie(@PathVariable String nomVille) {

        List<Prevision> listPrevision = ApiService.getPrevisionsMeteo(nomVille).getPrevisionList();
        List<Prevision> listPrevisionWithPluie = MeteoService.getPrevisionsWithPluie(listPrevision);

        return listPrevisionWithPluie;
    }



    @GetMapping(value = "{nomVille}/humidite/actuelle")
    public Integer getHumiditeActuelle(@PathVariable String nomVille) {
        ConditionActuelle conditionActuelle = ApiService.getPrevisionsMeteo(nomVille).getConditionActuelle();
        return conditionActuelle.getTauxHumidite();
    }

    @GetMapping(value = "{nomVille}/humidite/moyenne")
    public TreeMap<LocalDate, Double> getHumiditeMoyenne(@PathVariable String nomVille) {

        List<Prevision> listPrevision = ApiService.getPrevisionsMeteo(nomVille).getPrevisionList();
        TreeMap<LocalDate, Double> mapSorted = MeteoService.getMapHumiditeMoyenne(listPrevision);
        return mapSorted;
    }


    @GetMapping(value = "{nomVille}/humidite/min")
    public Prevision getJourhumiditeMinimal(@PathVariable String nomVille) {

        TreeMap<LocalDate, Double> mapDateHumiditeMoyenne = getHumiditeMoyenne(nomVille);
        Prevision previsionAvecMinHumidite = MeteoService.getJourneeHumiditeMini(nomVille, mapDateHumiditeMoyenne);

        return previsionAvecMinHumidite;
    }




}
