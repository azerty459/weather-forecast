package com.example.meteo.service;

import com.example.meteo.model.MeteoPrevision;
import org.json.JSONException;
import java.util.ArrayList;

public interface MeteoService {
    public ArrayList<MeteoPrevision> getPrevisionsForCity(String city) throws JSONException;
}
