package nextoo.weather.services;

import nextoo.weather.dto.HumidityDTO;
import nextoo.weather.dto.PrevisionDTO;
import nextoo.weather.services.api.PrevisionMeteoApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Service
public class PrevisionMeteoService {

    @Autowired
    PrevisionMeteoApiService previsionMeteoApiService;

    public PrevisionDTO getHottestDay(String name){
        List<PrevisionDTO> previsions = previsionMeteoApiService.findCityPrevision(name).getPrevisionList();
        return previsions.stream()
                .max(Comparator.comparingDouble(PrevisionDTO::getTemperatureMax))
                .get();
    }

    public Stream<PrevisionDTO> getRainyDays(String name) {
        List<PrevisionDTO> previsions = previsionMeteoApiService.findCityPrevision(name).getPrevisionList();
        Stream<PrevisionDTO> rainyDays = previsions.stream().filter(p -> (p.getHourlyData().values().stream().mapToDouble(pr -> pr.getPrecipitation()).average().getAsDouble()) > 0);
        return rainyDays;
    }

    public HumidityDTO getCurrentHumidity(String name){
        List<PrevisionDTO> previsions = previsionMeteoApiService.findCityPrevision(name).getPrevisionList();
        HumidityDTO humidityDTO = new HumidityDTO();
        Double weekAverage = previsions.stream().mapToDouble(p -> p.getHourlyData().entrySet().stream().mapToDouble(pr -> pr.getValue().getHumidity()).average().getAsDouble()).average().getAsDouble();

        humidityDTO.setCurrentHumidity(previsionMeteoApiService.findCityPrevision(name).getCurrentMeteo().getHumidity());
        humidityDTO.setWeekAverageHumdity(weekAverage);

        return humidityDTO;
    }

}
