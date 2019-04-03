package nextoo.weather.controller;

import nextoo.weather.entities.PrevisionEntity;
import nextoo.weather.entities.PrevisionMeteoEntity;
import nextoo.weather.services.PrevisionMeteoService;
import nextoo.weather.services.api.PrevisionMeteoApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/city")
public class PrevisionMeteoController {

    @Autowired
    PrevisionMeteoApiService previsionApiService;

    @Autowired
    PrevisionMeteoService previsionService;

    @GetMapping("/{name}")
    public PrevisionMeteoEntity findCityByName(@PathVariable( "name" ) String name){
        return previsionApiService.findCityPrevision(name);
    }

    @GetMapping("/{name}/hottestDay")
    public PrevisionEntity findHottestDayByName(@PathVariable( "name" ) String name){
        return previsionService.getHottestDay(name);
    }

    /*@GetMapping("/{name}/rainyDays")
    public PrevisionEntity findRainyDayByName(@PathVariable( "name" ) String name){
        return previsionService.getRainyDays(name);
    }*/

}
