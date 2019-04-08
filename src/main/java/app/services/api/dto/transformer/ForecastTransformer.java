package app.services.api.dto.transformer;

import app.services.api.dto.ForecastDTO;
import app.services.api.entity.Forecast;

public class ForecastTransformer {

    public static Forecast dtoToEntity(ForecastDTO fdto) {
        Forecast f = new Forecast();

        f.setCondition(fdto.getCondition());
        f.setDate(fdto.getDate());
        f.setHourly_data(fdto.getHourly_data());
        f.setTmax(fdto.getTmax());
        f.setTmin(fdto.getTmin());

        return f;
    }

    public static ForecastDTO entityToDto(Forecast f) {
        ForecastDTO fdto = new ForecastDTO();

        fdto.setCondition(f.getCondition());
        fdto.setDate(f.getDate());
        fdto.setHourly_data(f.getHourly_data());
        fdto.setTmax(f.getTmax());
        fdto.setTmin(f.getTmin());

        return fdto;
    }
}
