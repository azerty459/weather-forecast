package com.example.meteo.service;

import com.example.meteo.exception.JsonNotGottenException;
import com.example.meteo.helper.Helper;
import com.example.meteo.model.MeteoPrevision;
import com.example.meteo.model.apiobjects.ApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MeteoServiceImpl extends MeteoService{
    //Le service à api.openweathermap.org renvoit un paquet d'infos dont une liste de forecasts
    //Ces forecasts sont trop complexes et correspondent previsions trop frequentes
    //getPrevisionsForCity s'occupe donc de recuperer cette liste de forecasts,
    //  ne garder qu' un seul forecast par jour
    //  et transcrire ces forecasts en objet simples : MeteoPrevision

    @Override
    public List<MeteoPrevision> getPrevisionsForCity(String city) throws JsonNotGottenException, JSONException {

        //Obtenir réponse sous forme de string
        String url = "http://api.openweathermap.org/data/2.5/forecast?q="+city+"&appid=9a1ff30ffb4e8712900a02e4d5b8f182&units=metric&lang=fr";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String dataAsString = response.getBody();

        //checker reponse non vide
        if (dataAsString.length()==0)
        {
            throw new JsonNotGottenException("Response from url : " + url + " is empty");
        }

        //mapper sur un apiResponse
        ObjectMapper mapper = new ObjectMapper();
        ApiResponse apiResponse;
        try {
            apiResponse = mapper.readValue(dataAsString, ApiResponse.class);
        } catch (IOException e) {
            throw new JsonNotGottenException("Response couldn't be parsed");
        }

        //mapper sur une liste de prévisions
        List<MeteoPrevision> meteoPrevisionsFull = MeteoPrevision.meteoPrevisionsFrom(apiResponse);

        //retourner liste des index interessant : 0 car on garde temps "actuel", puis chaque fois qu'il est midi
        String dateFirst = meteoPrevisionsFull.get(0).date;
        return meteoPrevisionsFull.stream()
                .filter(mP->dateTimeFrom(mP.date).getHourOfDay() == 12||mP.date.equals(dateFirst))
                .collect(Collectors.toList());
    }

    private DateTime dateTimeFrom(String dateAsString) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        String datePremierePrevString = dateAsString;
        DateTime datePremierePrev = formatter.parseDateTime(datePremierePrevString);
        return datePremierePrev;
    }
}
