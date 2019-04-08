package app.services.api.dto.transformer;

import app.services.api.dto.CityDTO;
import app.services.api.entity.City;

import java.util.ArrayList;
import java.util.Arrays;

public class CityTransformer {

    public static City dtoToEntity (CityDTO cdto) {
        City c = new City();

        c.setName(cdto.getName());
        c.setHumidity(cdto.getHumidity());
        c.setFcst_day_0(ForecastTransformer.dtoToEntity(cdto.getForecasts().get(0)));
        c.setFcst_day_1(ForecastTransformer.dtoToEntity(cdto.getForecasts().get(1)));
        c.setFcst_day_2(ForecastTransformer.dtoToEntity(cdto.getForecasts().get(2)));
        c.setFcst_day_3(ForecastTransformer.dtoToEntity(cdto.getForecasts().get(3)));
        c.setFcst_day_4(ForecastTransformer.dtoToEntity(cdto.getForecasts().get(4)));

        return c;
    }

    public static CityDTO entityToDto (City c) {
        CityDTO cdto = new CityDTO();

        cdto.setHumidity(c.getHumidity());
        cdto.setName(c.getName());
        cdto.setForecasts(new ArrayList<>());
        cdto.getForecasts().addAll(Arrays.asList(ForecastTransformer.entityToDto(c.getFcst_day_0()),
                ForecastTransformer.entityToDto(c.getFcst_day_1()),
                ForecastTransformer.entityToDto(c.getFcst_day_2()),
                ForecastTransformer.entityToDto(c.getFcst_day_3()),
                ForecastTransformer.entityToDto(c.getFcst_day_4())));

        return cdto;
    }
}
