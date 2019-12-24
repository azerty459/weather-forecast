package fr.ia.meteo.meteo.api;

import fr.ia.meteo.meteo.api.dto.DtoToDoConverter;
import fr.ia.meteo.meteo.api.dto.RootDTO;
import fr.ia.meteo.meteo.entity.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {



    @Value("${api.url}")
    private String URL;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private  DtoToDoConverter converter;

    /***
     * Appel l'API www.prevision-meteo.ch et récupere la liste des prévisions de la ville
     * @param nomVille
     * @return container Root
     */
    public Root getPrevisionsMeteo(String nomVille) {
        System.out.println("URL = "+URL);
        RootDTO responseDTO = restTemplate.getForObject(URL + nomVille, RootDTO.class);
        return converter.convertDtoToDo(responseDTO);
    }
}
