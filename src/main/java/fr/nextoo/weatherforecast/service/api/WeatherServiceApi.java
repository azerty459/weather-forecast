package fr.nextoo.weatherforecast.service.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.nextoo.weatherforecast.bean.WeatherBean;
import fr.nextoo.weatherforecast.service.api.dto.ForecastDto;
import fr.nextoo.weatherforecast.service.api.dto.WeatherDto;
import fr.nextoo.weatherforecast.service.api.mapping.ForecastMapping;

@Service
public class WeatherServiceApi {

	private static final String APP_ID_NUMBER = "16fe170129730a58996ed579c78e01f2";
	private static final String FORECAST_URL_PATH = "http://api.openweathermap.org/data/2.5/forecast";

	public List<WeatherBean> getWeatherDaysByCity(String city) {

		Map<String, String> params = new HashMap<>();
		params.put("q", city);
		params.put("APPID", APP_ID_NUMBER);

		String url = generateUrl(FORECAST_URL_PATH, params);
		ForecastDto forecastDto = new RestTemplate().getForEntity(url, ForecastDto.class).getBody();

		List<WeatherDto> weatherDtoList = new LinkedList<WeatherDto>();
		if (forecastDto != null) {
			weatherDtoList = forecastDto.getWeatherDays();
		}
		return ForecastMapping.mappingWeatherDtoListToWeatherBeanList(weatherDtoList);
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
