package fr.ia.meteo.meteo.controller;

import fr.ia.meteo.meteo.job.ConditionActuelle;
import fr.ia.meteo.meteo.api.dto.RootDTO;
import fr.ia.meteo.meteo.job.Root;
import fr.ia.meteo.meteo.api.dto.PrevisionDTO;
import fr.ia.meteo.meteo.api.ApiService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/previsions")
public class MeteoController {


    @GetMapping(value = "{nomVille}")
    @ApiOperation("Retourne la liste des prévisions de la ville")
    public Root getAllPrevisions(@PathVariable String nomVille) {

        Root response = ApiService.getPrevisionsMeteo(nomVille);
        return  response;

    }


    @GetMapping(value = "{nomVille}/jourpluschaud")
    public PrevisionDTO getJourPlusChaud(@PathVariable String nomVille) {

        RootDTO listPrevision = ApiService.getPrevisionsMeteo(nomVille);
        PrevisionDTO previsionDTOJourTempMax = listPrevision.getPrevisionDTOList().stream()
                .max(Comparator.comparing(PrevisionDTO::getTempMax)).get();

        return previsionDTOJourTempMax;

    }


    @GetMapping(value = "{nomVille}/avecpluie")
    public List<PrevisionDTO> getListJourWithPluie(@PathVariable String nomVille) {

        List<PrevisionDTO> listPrevisionDTO = ApiService.getPrevisionsMeteo(nomVille).getPrevisionDTOList();
        List<PrevisionDTO> listPrevisionDTOWithPluie = listPrevisionDTO.stream()
                .filter(previsionDTO -> previsionDTO.getCondition().contains("Pluie"))
                .collect(Collectors.toList());

        return listPrevisionDTOWithPluie;
    }

    @GetMapping(value = "{nomVille}/humidite/actuelle")
    public Integer gethumiditeActuelle(@PathVariable String nomVille) {
        ConditionActuelle conditionActuelle = ApiService.getPrevisionsMeteo(nomVille).getConditionActuelle();
        return conditionActuelle.getTauxHumidite();
    }

    @GetMapping(value = "{nomVille}/humidite/moyenne")
    public HashMap<Double, String> gethumiditeMoyenne(@PathVariable String nomVille) {
        HashMap<Double, String> mapDateHumiditeMoyenne = new HashMap<>();
        List<Double> listhumiditeMoyenne = new ArrayList<>();
        List<PrevisionDTO> listPrevisionDTO = ApiService.getPrevisionsMeteo(nomVille).getPrevisionDTOList();
        listPrevisionDTO.stream()
                .forEach(
                        x -> mapDateHumiditeMoyenne.put(ApiService.calculerMoyenne(x), x.getDate())
                );
        return mapDateHumiditeMoyenne;
    }


    @GetMapping(value = "{nomVille}/humidite/min")
    public PrevisionDTO getJourhumiditeMinimal(@PathVariable String nomVille) {
        HashMap<Double, String> mapDateHumiditeMoyenne = gethumiditeMoyenne(nomVille);
        Double humiditeMin = mapDateHumiditeMoyenne.keySet().stream().min(Double::compareTo).get();
        String dateJourHumiditeMini = mapDateHumiditeMoyenne.get(humiditeMin);
        List<PrevisionDTO> listPrevisionDTO = ApiService.getPrevisionsMeteo(nomVille).getPrevisionDTOList();
        PrevisionDTO previsionDTOAvecMinHumidite = listPrevisionDTO.stream()
                .filter(previsionDTO -> previsionDTO.getDate().equals(dateJourHumiditeMini)).findAny().orElse(null);

        return previsionDTOAvecMinHumidite;
    }





}
