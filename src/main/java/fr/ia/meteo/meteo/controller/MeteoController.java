package fr.ia.meteo.meteo.controller;

import fr.ia.meteo.meteo.entity.ConditionActuelle;
import fr.ia.meteo.meteo.entity.Root;
import fr.ia.meteo.meteo.api.ApiService;
import fr.ia.meteo.meteo.entity.prevision.Prevision;
import fr.ia.meteo.meteo.service.MeteoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

/**
 * @author aioossen
 * Controller rest prévisions météo
 */

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping(value = "/previsions")
public class MeteoController {

    @Autowired
    private ApiService apiService;
    @Autowired
    private MeteoService meteoService;

    /***
     * Fournit la liste des prévisions météo de la ville
     * @param nomVille
     * @return entity Root
     */
    @GetMapping(value = "{nomVille}")
    @ApiOperation("Retourne la liste des prévisions de la ville")
    public Root getAllPrevisions(@PathVariable String nomVille) {

        Root response = apiService.getPrevisionsMeteo(nomVille);
        return response;

    }

    /***
     * Fournit la journée la plus chaude de la ville
     *
     * @param nomVille
     * @return Prevision
     */

    @GetMapping(value = "{nomVille}/jourpluschaud")
    public Prevision getJourPlusChaud(@PathVariable String nomVille) {

        return meteoService.getJourneePlusChaud(nomVille);

    }

    /***
     *Fournit la liste des journées avec pluie
     *
     * @param nomVille
     * @return Liste de prévision
     */
    @GetMapping(value = "{nomVille}/avecpluie")
    public List<Prevision> getListJourWithPluie(@PathVariable String nomVille) {

        List<Prevision> listPrevisionWithPluie = meteoService.getPrevisionsWithPluie(nomVille);

        return listPrevisionWithPluie;
    }


    /***
     * Fournit l'humidité actuelle de la ville
     *
     * @param nomVille
     * @return taux humidité
     */
    @GetMapping(value = "{nomVille}/humidite/actuelle")
    public Integer getHumiditeActuelle(@PathVariable String nomVille) {
        ConditionActuelle conditionActuelle = apiService.getPrevisionsMeteo(nomVille).getConditionActuelle();
        return conditionActuelle.getTauxHumidite();
    }

    /***
     * Fournit l'humidité moyenne des prévisions  de la ville
     *
     * @param nomVille
     * @return map (date + humidité)
     */
    @GetMapping(value = "{nomVille}/humidite/moyenne")
    public Map<LocalDate, Double> getHumiditeMoyenne(@PathVariable String nomVille) {


        Map<LocalDate, Double> mapSorted = meteoService.getMapHumiditeMoyenne(nomVille);
        return mapSorted;
    }

    /***
     * Fournit la journée relative à l'humidité minimale
     *
     * @param nomVille
     * @return Prevision
     */
    @GetMapping(value = "{nomVille}/humidite/min")
    public Prevision getJourhumiditeMinimal(@PathVariable String nomVille) {

        Prevision previsionAvecMinHumidite = meteoService.getJourneeHumiditeMini(nomVille);

        return previsionAvecMinHumidite;
    }


}
