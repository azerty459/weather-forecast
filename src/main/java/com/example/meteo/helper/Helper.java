package com.example.meteo.helper;

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
