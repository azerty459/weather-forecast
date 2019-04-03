package nextoo.weather.controller;

import nextoo.weather.dto.HumidityDTO;
import nextoo.weather.dto.PrevisionDTO;
import nextoo.weather.dto.PrevisionMeteoDTO;
import nextoo.weather.services.PrevisionMeteoService;
import nextoo.weather.services.api.PrevisionMeteoApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping("/city")
public class PrevisionMeteoController {

    @Autowired
    PrevisionMeteoApiService previsionApiService;

    @Autowired
    PrevisionMeteoService previsionService;

    @GetMapping("/{name}")
    public PrevisionMeteoDTO findCityByName(@PathVariable( "name" ) String name){
        return previsionApiService.findCityPrevision(name);
    }

    @GetMapping("/{name}/hottestDay")
    public PrevisionDTO findHottestDayByName(@PathVariable( "name" ) String name){
        return previsionService.getHottestDay(name);
    }

    @GetMapping("/{name}/rainyDays")
    public Stream<PrevisionDTO> findRainyDayByName(@PathVariable( "name" ) String name){
        return previsionService.getRainyDays(name);
    }

    @GetMapping("/{name}/humidity")
    public HumidityDTO findHumidityByName(@PathVariable( "name" ) String name){
        return previsionService.getCurrentHumidity(name);
    }

}
