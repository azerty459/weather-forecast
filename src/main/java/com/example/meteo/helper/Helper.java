package com.example.meteo.helper;

import org.json.JSONObject;

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
}
