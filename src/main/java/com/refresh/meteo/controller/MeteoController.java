package com.refresh.meteo.controller;

import com.refresh.meteo.bean.Prevision;
import com.refresh.meteo.prevmeteobean.PrevisionMeteoBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MeteoController {
    private static final String URL_API_WEATHER = "http://api.openweathermap.org/data/2.5/weather";
    private static final String ID_OPEN_WEATHER = "1164345a649ab00ff0e8da3a91f9b710";

    private static final String URL_PREV_METEO = "https://www.prevision-meteo.ch/services/json/";

    @RequestMapping("/prevision/find/{town}")
    public List<Prevision> findByTown(@PathVariable String town){
        try{
            PrevisionMeteoBean prevCh = callApiWeather(town);
            return mapperEnListPrevision(prevCh);
        }
        catch(URISyntaxException uriEx){

        }
        return null;
    }

    @RequestMapping("/prevision/findHottestDay/{town}")
    public Prevision findHottestDay(@PathVariable String town){
        return findByTown(town).stream().max( (prev1, prev2) -> prev1.getTemperatureMax()-prev2.getTemperatureMax()).get();
    }

    @RequestMapping("/prevision/findHottestDay/{town}")
    public List<Prevision> findRainyDays(@PathVariable String town){
        return findByTown(town).stream().filter(prev -> prev.getPluvieux()).collect(Collectors.toList());
    }



    private List<Prevision> mapperEnListPrevision(PrevisionMeteoBean prevCh) {
        List<Prevision> result = new ArrayList<>(5);
        result.add(new Prevision(prevCh.getJour0()));
        result.add(new Prevision(prevCh.getJour1()));
        result.add(new Prevision(prevCh.getJour2()));
        result.add(new Prevision(prevCh.getJour3()));
        result.add(new Prevision(prevCh.getJour4()));
        return result;
    }

    private final PrevisionMeteoBean callApiWeather(String town) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
/*
        HttpHeaders headers = new HttpHeaders();
        headers.set("APPID", ID_OPEN_WEATHER);
        headers.set("q","Paris");

        HttpEntity<Prevision> entity = new HttpEntity<Prevision>(headers);
        restTemplate.exchange(URL_API_WEATHER, HttpMethod.GET, entity, Prevision.class);
*/
        PrevisionMeteoBean result = restTemplate.getForObject(URL_PREV_METEO+town, PrevisionMeteoBean.class);
        return result;
    }
}
