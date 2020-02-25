package com.example.meteo.helper;

import com.example.meteo.exception.JsonNotGottenException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Helper {
    public static double returnAsDouble(Object o)
    {
        if (o instanceof Integer)
        {
            double d = (Integer) o;
            return d;
        }
        return (double) o;
    }

    public static JSONObject getUrlAsJson(String url) throws JsonNotGottenException
    {
        //Obtenir les données sous forme de String
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String dataAsString = response.getBody();

        if (dataAsString.length()==0)
        {
            throw new JsonNotGottenException("Response from url : " + url + " is empty");
        }

        //Les parser en JSONObject
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(dataAsString);
        }catch (JSONException err){
            throw new JsonNotGottenException("JSONException : " + err.getMessage());
        }
        return jsonObject;
    }

    public static List<JSONObject> getJSONArrayAsListOfJsonObjects(JSONArray jsonArray) throws JSONException {
        List<JSONObject> listToReturn = new ArrayList<>();
        for (int i=0; i<jsonArray.length(); i++)
        {
            listToReturn.add(jsonArray.getJSONObject(i));
        }
        return  listToReturn;
    }
}
