package nextoo.exercices.apiweather.utilitaries;

import nextoo.exercices.apiweather.business.entities.DayForecast;
import nextoo.exercices.apiweather.entrypoint.dto.DayForecastDTO;
import nextoo.exercices.apiweather.externalServices.previsionMeteoService.dto.PMSDayForecastDTO;

import java.util.List;
import java.util.stream.Collectors;

public class DayForecastTransformer {

    public static DayForecastDTO entityToDto(DayForecast entity) {
        DayForecastDTO result = new DayForecastDTO();
        result.setCondition(entity.getCondition());
        result.setDate(entity.getDate());
        result.setMaxTemperature(entity.getMaxTemperature());
        result.setMinTemperature(entity.getMinTemperature());
        result.setHourlyDatas(HourlyDataTransformer.entityToDto(entity.getHourlyDatas()));
        result.setIcon(entity.getIcon());
        result.setAverageData(CalculationsTransformer.entityToDto(entity.getAverageData()));
        return result;
    }

    public static DayForecast dtoToEntity(DayForecastDTO dto) {
        DayForecast result = new DayForecast();
        result.setCondition(dto.getCondition());
        result.setDate(dto.getDate());
        result.setMaxTemperature(dto.getMaxTemperature());
        result.setMinTemperature(dto.getMinTemperature());
        result.setHourlyDatas(HourlyDataTransformer.dtoToEntity(dto.getHourlyDatas()));
        result.setIcon(dto.getIcon());
        return result;
    }

    public static List<DayForecastDTO> entityToDto (List<DayForecast> entities) {
        return entities.stream()
                .map(entity -> entityToDto(entity))
                .collect(Collectors.toList());
    }

    public static List<DayForecast> dtoToEntity (List<DayForecastDTO> dtos) {
        return dtos.stream()
                .map(dto -> dtoToEntity(dto))
                .collect(Collectors.toList());
    }

    public static DayForecast pmsDtoToEntity (PMSDayForecastDTO pms) {
        DayForecast result = new DayForecast();
        result.setHourlyDatas(HourlyDataTransformer.pmsDtoToEntity(pms.getHourlyDatas()));
        result.setCondition(pms.getCondition());
        result.setDate(pms.getDate());
        result.setMaxTemperature(pms.getMaxTemperature());
        result.setMinTemperature(pms.getMinTemperature());
        result.setIcon(pms.getIcon());
        return result;
    }
}
