package fr.nextoo.weatherforecast.service;

import java.util.List;

public interface RainyDaysService {

    public List<String> getOnlyRainyDaysByCity(String ville);
}
