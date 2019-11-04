package fr.nextoo.weatherforecast.service;

import java.util.List;

public interface RainyDaysService {
    public List<Boolean> getRainyDaysByCity(String ville);
}
