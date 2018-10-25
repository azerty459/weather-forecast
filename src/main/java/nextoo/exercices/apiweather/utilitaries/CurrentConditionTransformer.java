package nextoo.exercices.apiweather.utilitaries;

import nextoo.exercices.apiweather.business.entities.CurrentCondition;
import nextoo.exercices.apiweather.entrypoint.dto.CurrentConditionDTO;
import nextoo.exercices.apiweather.externalServices.previsionMeteoService.dto.PMSCurrentConditionDTO;

public class CurrentConditionTransformer {

    public static CurrentConditionDTO entityToDto(CurrentCondition entity) {
        CurrentConditionDTO result = new CurrentConditionDTO();
        result.setCondition(entity.getCondition());
        result.setDate(entity.getDate());
        result.setHour(entity.getHour());
        result.setHumidity(entity.getHumidity());
        result.setPressure(entity.getPressure());
        result.setTemperature(entity.getTemperature());
        result.setWindDirection(entity.getWindDirection());
        result.setWindGustSpeed(entity.getWindGustSpeed());
        result.setWindSpeed(entity.getWindSpeed());
        result.setIcon(entity.getIcon());
        return result;
    }

    public static CurrentCondition dtoToEntity(CurrentConditionDTO dto) {
        CurrentCondition result = new CurrentCondition();
        result.setCondition(dto.getCondition());
        result.setDate(dto.getDate());
        result.setHour(dto.getHour());
        result.setHumidity(dto.getHumidity());
        result.setPressure(dto.getPressure());
        result.setTemperature(dto.getTemperature());
        result.setWindDirection(dto.getWindDirection());
        result.setWindGustSpeed(dto.getWindGustSpeed());
        result.setWindSpeed(dto.getWindSpeed());
        result.setIcon(dto.getIcon());
        return result;
    }

    public static CurrentCondition pmsDtoToEntity(PMSCurrentConditionDTO pms) {
        CurrentCondition result = new CurrentCondition();
        result.setCondition(pms.getCondition());
        result.setDate(pms.getDate());
        result.setHour(pms.getHour());
        result.setHumidity(pms.getHumidity());
        result.setPressure(pms.getPressure());
        result.setTemperature(pms.getTemperature());
        result.setWindDirection(pms.getWindDirection());
        result.setWindGustSpeed(pms.getWindGustSpeed());
        result.setWindSpeed(pms.getWindSpeed());
        result.setIcon(pms.getIcon());
        return result;
    }
}