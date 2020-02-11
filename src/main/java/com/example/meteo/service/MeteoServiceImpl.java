package com.example.meteo.service;

import com.example.meteo.helper.Helper;
import com.example.meteo.model.MeteoPrevision;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class MeteoServiceImpl implements MeteoService{

    DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public ArrayList<MeteoPrevision> getPrevisionsForCity(String city) throws JSONException {
        //Obtenir les données sous forme de String
        String url = "http://api.openweathermap.org/data/2.5/forecast?q="+city+"&appid=9a1ff30ffb4e8712900a02e4d5b8f182&units=metric&lang=fr";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        String dataAsString = response.getBody();

        //Les parser en JSONObject
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(dataAsString);
        }catch (JSONException err){
            System.err.println(err.toString());
        }

        //extraire du JSONObject la liste de prévisions
        JSONArray listOfForecasts = (JSONArray)jsonObject.get("list");

        //Initialiser liste a rendre
        ArrayList<MeteoPrevision> listeARendre = new ArrayList<>();

        //parcourir la liste, transformer les JSONObject contenus dans la liste en MeteoInfo
        //ajouter les previsions voulues dans la listeARendre
        DateTime datePremierePrev = null;
        for(int n = 0; n < listOfForecasts.length(); n++)
        {
            JSONObject object = listOfForecasts.getJSONObject(n);

            //Obtenir date concernee
            DateTime dateTime = formatter.parseDateTime((String) object.get("dt_txt"));

            //noter la date de la premiere prediction
            if (n==0)
            {
                datePremierePrev = dateTime;
            }

            //Si premiere prevision, ou bien jour suivant heure = midi, alors ajouter a la liste à rendre
            if (n==0 || (dateTime.getHourOfDay()==12 && dateTime.getDayOfYear()>datePremierePrev.getDayOfYear())) {
                MeteoPrevision meteoPrev = new MeteoPrevision(
                        (String) object.get("dt_txt"),
                        (String)((JSONObject) ((JSONArray)object.get("weather")).get(0)).get("description"),
                        Helper.returnAsDouble(((JSONObject)object.get("main")).get("temp")),
                        Helper.returnAsDouble(((JSONObject)object.get("main")).get("humidity"))
                );
                listeARendre.add(meteoPrev);
            }
        }
        return listeARendre;
    }

}
