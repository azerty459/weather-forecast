package nextoo.weather.services;

import nextoo.weather.entities.PrevisionEntity;
import nextoo.weather.services.api.PrevisionMeteoApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrevisionMeteoService {

    @Autowired
    PrevisionMeteoApiService previsionMeteoApiService;

    public PrevisionEntity getHottestDay(String name){
        List<PrevisionEntity> previsions = previsionMeteoApiService.findCityPrevision(name).getPrevisionList();
        return previsions.stream()
                .max(Comparator.comparingDouble(PrevisionEntity::getTemperatureMax))
                .get();
    }

    /*public PrevisionEntity getRainyDays(String name) {
        List<PrevisionEntity> previsions = previsionMeteoApiService.findCityPrevision(name).getPrevisionList();
        return previsions.stream().filter(p -> p.getCondition().toLowerCase().contains("pluie")).map(p -> p.getCondition());
    }*/

}
