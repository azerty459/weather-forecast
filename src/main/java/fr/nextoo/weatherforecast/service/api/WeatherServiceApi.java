package fr.nextoo.weatherforecast.service.api;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.nextoo.weatherforecast.service.api.dto.CurrentForecastDto;
import fr.nextoo.weatherforecast.service.api.dto.DaysListForecastsDto;
import fr.nextoo.weatherforecast.service.api.mapping.ForecastMapping;
import fr.nextoo.weatherforecast.web.bean.DayForecastBean;
import fr.nextoo.weatherforecast.web.bean.ForecastsDetailsBean;
import fr.nextoo.weatherforecast.web.bean.ForecastBean;

@Service
public class WeatherServiceApi {

	private static final String APP_ID_NUMBER = "16fe170129730a58996ed579c78e01f2";
	private static final String FORECAST_URL_PATH = "http://api.openweathermap.org/data/2.5/forecast";
	private static final String WEATHER_URL_PATH = "http://api.openweathermap.org/data/2.5/weather";

	/**
	 * API HTTP call : GET CurrentForecast for the city
	 * @param cityName
	 * @return CurrentForecast
	 */
	public DayForecastBean getCurrentWeather(String cityName) {
		Map<String, String> params = new HashMap<>();
		params.put("q", cityName);
		params.put("units", "metric");
		params.put("APPID", APP_ID_NUMBER);

		String url = generateUrl(WEATHER_URL_PATH, params);
		CurrentForecastDto currentForecastDto = new RestTemplate().getForEntity(url, CurrentForecastDto.class).getBody();

		return currentForecastDto == null ? null : ForecastMapping.mappingCurrentForecastDtoToBean(currentForecastDto);
	}

	/**
	 * API HTTP call : GET Forecasts for the city
	 * @param cityName
	 * @return DailyForecasts list
	 */
	public List<ForecastsDetailsBean> getDailyForecastsList(String cityName) {
		Map<String, String> params = new HashMap<>();
		params.put("q", cityName);
		params.put("units", "metric");
		params.put("APPID", APP_ID_NUMBER);

		String url = generateUrl(FORECAST_URL_PATH, params);
		DaysListForecastsDto city5DaysForecastDto = new RestTemplate().getForEntity(url, DaysListForecastsDto.class).getBody();

		if(city5DaysForecastDto == null) {
			return Collections.emptyList();
		}

		return ForecastMapping.mappingForecastsDtoListToForecastsDetailsBeanList(city5DaysForecastDto.getForecasts());
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
