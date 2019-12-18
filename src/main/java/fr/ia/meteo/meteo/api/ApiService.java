package fr.ia.meteo.meteo.api;

import fr.ia.meteo.meteo.api.dto.RootDTO;
import fr.ia.meteo.meteo.api.dto.PrevisionDTO;
import fr.ia.meteo.meteo.api.dto.PrevisionHoraireDTO;
import fr.ia.meteo.meteo.job.Root;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.HashMap;

public class ApiService {

    public static Root getPrevisionsMeteo(String nomVille) {
        RestTemplate restTemplate = new RestTemplate();
        DtoToDoConverter converter = new DtoToDoConverter();

        RootDTO responseDTO = restTemplate.getForObject("https://www.prevision-meteo.ch/services/json/" + nomVille, RootDTO.class);
        return converter.convertDtoToDo(responseDTO);
    }


    public static Double calculerMoyenne(PrevisionDTO previsionDTO) {

        HashMap<String, PrevisionHoraireDTO> mapPrevisionHoraireList = previsionDTO.getPrevisionHoraireListDTO().getPrevisionHoraireList();
        Collection<PrevisionHoraireDTO> previsionHoraireDTOCollection = mapPrevisionHoraireList.values();
         return previsionHoraireDTOCollection.stream()
                .mapToInt(PrevisionHoraireDTO::getTauxHumidite)
                .average().orElse(0) ;

    }
}
