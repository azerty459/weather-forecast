package com.example.meteo.controller;

import com.example.meteo.model.MeteoPrevision;
import com.example.meteo.service.MeteoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@RequestMapping("/api")
public class MeteoController {
    @Autowired
    MeteoService service;

    @GetMapping("/meteo/{ville}")
    public ResponseEntity<ArrayList<MeteoPrevision>> getInfos(@PathVariable(value = "ville") String ville) throws Exception {
        ArrayList<MeteoPrevision> previsions = service.getPrevisionsForCity(ville);
        return ResponseEntity.ok().body(previsions);
    }
}
