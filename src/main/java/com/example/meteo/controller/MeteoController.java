package com.example.meteo.controller;

import com.example.meteo.model.HumidityStats;
import com.example.meteo.model.MeteoPrevision;
import com.example.meteo.service.MeteoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class MeteoController {

    //TO DO - gerer les exceptions pour renvoyer message d'erreur approprié

    @Autowired
    MeteoService service;

    @GetMapping("/meteo/{ville}")
    public ResponseEntity<List<MeteoPrevision>> getInfos(@PathVariable(value = "ville") String ville) throws Exception {
        List<MeteoPrevision> previsions = service.getPrevisionsForCity(ville);
        return ResponseEntity.ok().body(previsions);
    }

    @GetMapping("/meteo/{ville}/hottestday")
    public ResponseEntity<MeteoPrevision> getHottestDay(@PathVariable(value = "ville") String ville) throws Exception {
        MeteoPrevision previsionHottestDay = service.getHottestDayForCity(ville);
        return ResponseEntity.ok().body(previsionHottestDay);
    }

    @GetMapping("/meteo/{ville}/rainydays")
    public ResponseEntity<List<MeteoPrevision>> getRainyDays(@PathVariable(value = "ville") String ville) throws Exception {
        List<MeteoPrevision> rainyDays = service.getRainyDaysForCity(ville);
        return ResponseEntity.ok().body(rainyDays);
    }

    @GetMapping("/meteo/{ville}/" +
            "")
    public ResponseEntity<HumidityStats> getHumidityStats(@PathVariable(value = "ville") String ville) throws Exception {
        HumidityStats humidityStatsForCity = service.getHumidityStatsForCity(ville);
        return ResponseEntity.ok().body(humidityStatsForCity);
    }
}
