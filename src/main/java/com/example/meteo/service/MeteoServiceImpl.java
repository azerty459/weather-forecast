package com.example.meteo.service;

import com.example.meteo.exception.JsonNotGottenException;
import com.example.meteo.helper.Helper;
import com.example.meteo.model.MeteoPrevision;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

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

        //Obtenir liste de forecasts pour la ville : city
        String url = "http://api.openweathermap.org/data/2.5/forecast?q="+city+"&appid=9a1ff30ffb4e8712900a02e4d5b8f182&units=metric&lang=fr";
        JSONObject jsonObject = Helper.getUrlAsJson(url);
        JSONArray jsonArray = (JSONArray)jsonObject.get("list");
        List<JSONObject> listOfForecasts = Helper.getJSONArrayAsListOfJsonObjects(jsonArray);

        //Obtenir liste des index interessant : 0 car on garde temps "actuel", puis chaque fois qu'il est midi
            //Extraire une liste (parralèle) de dates
        List<DateTime> listOfDates = listOfForecasts.stream().map(o->dateTimeFrom(o)).collect(Collectors.toList());
            //Extraire les index puis maper aux meteoPrev
        List<MeteoPrevision> meteoPrevisions = IntStream
                .range(0, listOfDates.size())
                .filter(i -> i == 0 || listOfDates.get(i).getHourOfDay() == 12)
                .mapToObj(i -> previsionFrom(listOfForecasts.get(i))).collect(Collectors.toList());

        return meteoPrevisions;
    }


    private MeteoPrevision previsionFrom(JSONObject forecast) {
        String dt_txt;
        String description;
        double temperature;
        double humidity;
        try {
            dt_txt = (String) forecast.get("dt_txt");
            description = (String) ((JSONObject) ((JSONArray) forecast.get("weather")).get(0)).get("description");
            temperature = Helper.returnAsDouble(((JSONObject) forecast.get("main")).get("temp"));
            humidity = Helper.returnAsDouble(((JSONObject) forecast.get("main")).get("humidity"));
        } catch (JSONException e) {
            return null;
        }
        MeteoPrevision meteoPrev = new MeteoPrevision(dt_txt, description, temperature, humidity);
        return meteoPrev;
    }

    private DateTime dateTimeFrom(JSONObject forecast) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        String datePremierePrevString = null;
        try {
            datePremierePrevString = (String) forecast.get("dt_txt");
        } catch (JSONException e) {
            return null;
        }
        DateTime datePremierePrev = formatter.parseDateTime(datePremierePrevString);
        return datePremierePrev;
    }
}
