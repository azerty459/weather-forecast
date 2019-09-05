package fr.nextoo.weatherforecast.service.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.nextoo.weatherforecast.bean.ForecastBean;
import fr.nextoo.weatherforecast.service.api.dto.City5DaysForecastDto;
import fr.nextoo.weatherforecast.service.api.dto.ForecastDto;
import fr.nextoo.weatherforecast.service.api.mapping.ForecastMapping;

@Service
public class WeatherServiceApi {

	private static final String APP_ID_NUMBER = "16fe170129730a58996ed579c78e01f2";
	private static final String FORECAST_URL_PATH = "http://api.openweathermap.org/data/2.5/forecast";

	public Map<String, List<ForecastBean>> getDailyForecastsByCity(String city) {
		return ForecastMapping.mappingForecastDtoToDailyForecastBean(this.getForecastsByCityApi(city));
	}

	public List<ForecastBean> getForecastsByCity(String city) {
		return ForecastMapping.mappingForecastDtoToForecastBean(this.getForecastsByCityApi(city));
	}

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

	private String sendHttpRequest(URL url, String method, String contentType) throws IOException {

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod(method);
		connection.setRequestProperty("Content-Type", contentType);

		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();

		while ((inputLine = reader.readLine()) != null) {
			content.append(inputLine);
		}

		reader.close();
		connection.disconnect();

		return content.toString();
	}

	/**
	 * Generate an URL with HTTP params
	 *
	 * @param basePath
	 * @param params
	 * @return URL
	 */
	private String generateUrl(final String basePath, final Map<String, String> params) {
		String paramsFormatted = this.generateParams(params);
		String pathFormatted = paramsFormatted.length() > 0
				? new StringBuilder(basePath).append("?").append(paramsFormatted).toString()
						: basePath;
				return pathFormatted;
	}

	/**
	 * generate params for HTTP request format : "key=value&key2=value2"
	 *
	 * @param params
	 * @return params formatted
	 */
	private String generateParams(final Map<String, String> params) {
		StringBuilder paramsBuilder = new StringBuilder();

		params.forEach((key, value) -> {
			paramsBuilder.append(paramsBuilder.length() == 0 ? "" : "&");
			paramsBuilder.append(key).append("=").append(value);
		});
		return paramsBuilder.toString();
	}

}
