package com.example.meteo.service;

import com.example.meteo.exception.JsonNotGottenException;
import com.example.meteo.model.HumidityStats;
import com.example.meteo.model.MeteoPrevision;
import org.json.JSONException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class MeteoService {
    abstract public List<MeteoPrevision> getPrevisionsForCity(String city) throws JsonNotGottenException, JSONException;

    //    afficher le jour le plus chaud de la semaine
    public MeteoPrevision getHottestDayForCity(String city) throws JSONException, JsonNotGottenException {
        List<MeteoPrevision> previsions = this.getPrevisionsForCity(city);
        Optional<MeteoPrevision> max = previsions.stream().max((p, q) -> p.temperature > q.temperature ? 1 : -1);
        return max.get();
    }

    //    afficher uniquement les jours où il pleut
    // TO DO : bien redefinir si pleut ou pas
    public List<MeteoPrevision> getRainyDaysForCity(String city) throws JSONException, JsonNotGottenException {
    List<MeteoPrevision> previsions = this.getPrevisionsForCity(city);
    Stream<MeteoPrevision> rainyDays = previsions.stream().filter(p->p.humidity>50);
    return rainyDays.collect(Collectors.toCollection(ArrayList::new));
    }
//    afficher les villes dans un périmètre de 50km où il fait plus chaud que la ville demandée (peut être pas possible, expliquer pourquoi si c’est le cas).
//    difficile : requiert accés à liste de villes dans un rayon de 50km pour ville donnée...complique

//    afficher l’humidité actuelle, celle moyenne pour chaque jour de la semaine, et le détail du jour le plus sec (peut être pas possible, expliquer pourquoi si c’est le cas).
    public HumidityStats getHumidityStatsForCity(String city) throws JSONException, JsonNotGottenException {
        List<MeteoPrevision> previsions = this.getPrevisionsForCity(city);
        double currentHumidity = previsions.get(0).humidity;
        double meanHumidity = previsions.stream().collect(Collectors.summingDouble(p->p.humidity)) / ((double) previsions.size());
        Optional<MeteoPrevision> driestDayPrevision = previsions.stream().min((p, q) -> p.humidity > q.humidity ? 1 : -1);
        return new HumidityStats(currentHumidity, meanHumidity, driestDayPrevision.get());
    }
}
