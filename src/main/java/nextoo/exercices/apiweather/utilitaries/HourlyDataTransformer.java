package nextoo.exercices.apiweather.utilitaries;

import nextoo.exercices.apiweather.business.entities.CurrentCondition;
import nextoo.exercices.apiweather.business.entities.HourlyData;
import nextoo.exercices.apiweather.entrypoint.dto.HourlyDataDTO;
import nextoo.exercices.apiweather.externalServices.previsionMeteoService.dto.PMSCurrentConditionDTO;
import nextoo.exercices.apiweather.externalServices.previsionMeteoService.dto.PMSHourlyDataDTO;
import nextoo.exercices.apiweather.externalServices.previsionMeteoService.dto.PMSHourlyDatasListDTO;

import java.util.ArrayList;
import java.util.List;

public class HourlyDataTransformer {

    public static List<HourlyData> pmsDtoToEntity(PMSHourlyDatasListDTO pms) {
        List<HourlyData> hourlyDatasList = new ArrayList<>();
        if (pms.getHour0() != null)
            hourlyDatasList.add(pmsDtoToEntity(pms.getHour0(),0));
        if (pms.getHour1() != null)
            hourlyDatasList.add(pmsDtoToEntity(pms.getHour1(),1));
        if (pms.getHour2() != null)
            hourlyDatasList.add(pmsDtoToEntity(pms.getHour2(),2));
        if (pms.getHour3() != null)
            hourlyDatasList.add(pmsDtoToEntity(pms.getHour3(),3));
        if (pms.getHour4() != null)
            hourlyDatasList.add(pmsDtoToEntity(pms.getHour4(),4));
        if (pms.getHour5() != null)
            hourlyDatasList.add(pmsDtoToEntity(pms.getHour5(),5));
        if (pms.getHour6() != null)
            hourlyDatasList.add(pmsDtoToEntity(pms.getHour6(),6));
        if (pms.getHour7() != null)
            hourlyDatasList.add(pmsDtoToEntity(pms.getHour7(),7));
        if (pms.getHour8() != null)
            hourlyDatasList.add(pmsDtoToEntity(pms.getHour8(),8));
        if (pms.getHour9() != null)
            hourlyDatasList.add(pmsDtoToEntity(pms.getHour9(),9));
        if (pms.getHour10() != null)
            hourlyDatasList.add(pmsDtoToEntity(pms.getHour10(),10));
        if (pms.getHour11() != null)
            hourlyDatasList.add(pmsDtoToEntity(pms.getHour11(),11));
        if (pms.getHour12() != null)
            hourlyDatasList.add(pmsDtoToEntity(pms.getHour12(),12));
        if (pms.getHour13() != null)
            hourlyDatasList.add(pmsDtoToEntity(pms.getHour13(),13));
        if (pms.getHour14() != null)
            hourlyDatasList.add(pmsDtoToEntity(pms.getHour14(),14));
        if (pms.getHour15() != null)
            hourlyDatasList.add(pmsDtoToEntity(pms.getHour15(),15));
        if (pms.getHour16() != null)
            hourlyDatasList.add(pmsDtoToEntity(pms.getHour16(),16));
        if (pms.getHour17() != null)
            hourlyDatasList.add(pmsDtoToEntity(pms.getHour17(),17));
        if (pms.getHour18() != null)
            hourlyDatasList.add(pmsDtoToEntity(pms.getHour18(),18));
        if (pms.getHour19() != null)
            hourlyDatasList.add(pmsDtoToEntity(pms.getHour19(),19));
        if (pms.getHour20() != null)
            hourlyDatasList.add(pmsDtoToEntity(pms.getHour20(),20));
        if (pms.getHour21() != null)
            hourlyDatasList.add(pmsDtoToEntity(pms.getHour21(),21));
        if (pms.getHour22() != null)
            hourlyDatasList.add(pmsDtoToEntity(pms.getHour22(),22));
        if (pms.getHour23() != null)
            hourlyDatasList.add(pmsDtoToEntity(pms.getHour23(),23));
        return hourlyDatasList;
    }

    private static HourlyData pmsDtoToEntity (PMSHourlyDataDTO pms, int hour) {
        HourlyData result = new HourlyData();
        result.setHour(hour);
        result.setAtmosphericPressure(pms.getAtmosphericPressure());
        result.setCondition(pms.getCondition());
        result.setDewPoint(pms.getDewPoint());
        result.setIcon(pms.getIcon());
        result.setPrecipitation(pms.getPrecipitation());
        result.setRelativeHumidity(pms.getRelativeHumidity());
        result.setTemp(pms.getTemp());
        result.setWindChill(pms.getWindChill());
        result.setWindDirectionCardinal(pms.getWindDirectionCardinal());
        result.setWindDirectionDegree(pms.getWindDirectionDegree());
        result.setWindGustSpeed(pms.getWindGustSpeed());
        result.setWindSpeed(pms.getWindSpeed());
        return result;
    }

    public static HourlyDataDTO entityToDto (HourlyData entity) {
        HourlyDataDTO result = new HourlyDataDTO();
        result.setHour(entity.getHour());
        result.setAtmosphericPressure(entity.getAtmosphericPressure());
        result.setCondition(entity.getCondition());
        result.setDewPoint(entity.getDewPoint());
        result.setIcon(entity.getIcon());
        result.setPrecipitation(entity.getPrecipitation());
        result.setRelativeHumidity(entity.getRelativeHumidity());
        result.setTemp(entity.getTemp());
        result.setWindChill(entity.getWindChill());
        result.setWindDirectionCardinal(entity.getWindDirectionCardinal());
        result.setWindDirectionDegree(entity.getWindDirectionDegree());
        result.setWindGustSpeed(entity.getWindGustSpeed());
        result.setWindSpeed(entity.getWindSpeed());
        return result;
    }

    public static List<HourlyDataDTO> entityToDto (List<HourlyData> entity) {
        List<HourlyDataDTO> result = new ArrayList<>();
        entity.forEach(
                hd -> result.add(HourlyDataTransformer.entityToDto(hd))
        );
        return result;
    }


    public static HourlyData dtoToEntity (HourlyDataDTO entity) {
        HourlyData result = new HourlyData();
        result.setHour(entity.getHour());
        result.setAtmosphericPressure(entity.getAtmosphericPressure());
        result.setCondition(entity.getCondition());
        result.setDewPoint(entity.getDewPoint());
        result.setIcon(entity.getIcon());
        result.setPrecipitation(entity.getPrecipitation());
        result.setRelativeHumidity(entity.getRelativeHumidity());
        result.setTemp(entity.getTemp());
        result.setWindChill(entity.getWindChill());
        result.setWindDirectionCardinal(entity.getWindDirectionCardinal());
        result.setWindDirectionDegree(entity.getWindDirectionDegree());
        result.setWindGustSpeed(entity.getWindGustSpeed());
        result.setWindSpeed(entity.getWindSpeed());
        return result;
    }

    public static List<HourlyData> dtoToEntity (List<HourlyDataDTO> entity) {
        List<HourlyData> result = new ArrayList<>();
        entity.forEach(
                hd -> result.add(HourlyDataTransformer.dtoToEntity(hd))
        );
        return result;
    }
}
