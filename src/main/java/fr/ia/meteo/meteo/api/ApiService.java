package fr.ia.meteo.meteo.api;

import fr.ia.meteo.meteo.api.dto.PrevisionHoraireListDTO;
import fr.ia.meteo.meteo.api.dto.RootDTO;
import fr.ia.meteo.meteo.api.dto.PrevisionDTO;
import fr.ia.meteo.meteo.api.dto.PrevisionHoraireDTO;
import fr.ia.meteo.meteo.job.Root;
import fr.ia.meteo.meteo.job.prevision.Prevision;
import fr.ia.meteo.meteo.job.prevision.PrevisionHoraire;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ApiService {

    public static Root getPrevisionsMeteo(String nomVille) {
        RestTemplate restTemplate = new RestTemplate();
        DtoToDoConverter converter = new DtoToDoConverter();
        RootDTO responseDTO = restTemplate.getForObject("https://www.prevision-meteo.ch/services/json/" + nomVille, RootDTO.class);
        return converter.convertDtoToDo(responseDTO);
    }

}
