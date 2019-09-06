package fr.nextoo.weatherforecast.service.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.nextoo.weatherforecast.bean.DailyForecastBean;
import fr.nextoo.weatherforecast.service.api.dto.City5DaysForecastDto;
import fr.nextoo.weatherforecast.service.api.dto.ForecastDto;
import fr.nextoo.weatherforecast.service.api.mapping.ForecastMapping;

@Service
public class WeatherServiceApi {

	private static final String APP_ID_NUMBER = "16fe170129730a58996ed579c78e01f2";
	private static final String FORECAST_URL_PATH = "http://api.openweathermap.org/data/2.5/forecast";

	/**
	 * Get DailyForcasts List for the city converted (bean)
	 * @param city
	 * @return DailyForecasts list
	 */
	public List<DailyForecastBean> getDailyForecastsByCity(String city) {
		return ForecastMapping.mappingForecastsDtoListToDailyForecastBeanList(this.getForecastsByCityApi(city));
	}

	/**
	 * API HTTP call : GET Forecasts for the city
	 * @param city
	 * @return Forecasts
	 */
	private List<ForecastDto> getForecastsByCityApi(String city){
		Map<String, String> params = new HashMap<>();
		params.put("q", city);
		params.put("APPID", APP_ID_NUMBER);

		String url = generateUrl(FORECAST_URL_PATH, params);
		City5DaysForecastDto city5DaysForecastDto = new RestTemplate().getForEntity(url, City5DaysForecastDto.class).getBody();

		List<ForecastDto> forecastsDto = new ArrayList<>();
		if(city5DaysForecastDto != null) {
			forecastsDto = city5DaysForecastDto.getForecasts();
		}
		return forecastsDto;
	}

	/**
	 * Generate an URL with HTTP parameters
	 *
	 * @param basePath
	 * @param params
	 * @return URL
	 */
	private String generateUrl(final String basePath, final Map<String, String> parameters) {
		String parametersFormatted = this.generateParameters(parameters);
		String pathFormatted = parametersFormatted.length() > 0
				? new StringBuilder(basePath).append("?").append(parametersFormatted).toString()
						: basePath;
				return pathFormatted;
	}

	/**
	 * generate parameters for HTTP request format : "key=value&key2=value2"
	 *
	 * @param parameters
	 * @return parameters formatted
	 */
	private String generateParameters(final Map<String, String> parameters) {
		StringBuilder parametersBuilder = new StringBuilder();

		parameters.forEach((key, value) -> {
			parametersBuilder.append(parametersBuilder.length() == 0 ? "" : "&");
			parametersBuilder.append(key).append("=").append(value);
		});
		return parametersBuilder.toString();
	}

}
