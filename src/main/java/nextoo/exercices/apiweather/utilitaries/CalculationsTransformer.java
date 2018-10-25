package nextoo.exercices.apiweather.utilitaries;

import nextoo.exercices.apiweather.business.entities.Calculations;
import nextoo.exercices.apiweather.entrypoint.dto.CalculationsDTO;

public class CalculationsTransformer {

    public static CalculationsDTO entityToDto(Calculations entity) {
        CalculationsDTO result = new CalculationsDTO();
        result.setAtmosphericPressureAverage(entity.getAverageAtmosphericPressure());
        result.setDewPointAverage(entity.getAverageDewPoint());
        result.setPrecipitationAverage(entity.getAveragePrecipitation());
        // TODO changer float to dto
        result.setRelativeHumidityAverage(new Float(entity.getAverageRelativeHumidity()));
        result.setWindChillAverage(entity.getAverageWindChill());
        result.setWindGustSpeedAverage(entity.getAverageWindGustSpeed());
        result.setWindSpeedAverage(entity.getAverageWindSpeed());
        result.setTemperatureAverage(entity.getTemperatureAverage());
        return result;
    }

}
