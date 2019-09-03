package fr.nextoo.weatherforecast.service.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.nextoo.weatherforecast.dto.WeatherDto;

@Service
public class WeatherServiceApi {

	final String CURRENT_URL = "http://api.openweathermap.org/data/2.5/weather";
	
	public WeatherDto getCurrentWeatherByCity(String city) {
		WeatherDto weatherDto = null;
		
		Map<String, String> params = new HashMap<>();
		params.put("q", city);
		params.put("APPID", "16fe170129730a58996ed579c78e01f2");

		URL url;
		try {
			url = this.generateUrl(CURRENT_URL, params);
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			
			while((inputLine = reader.readLine()) != null) {
				content.append(inputLine);
			}
			reader.close();
			connection.disconnect();
						
			ObjectMapper mapper = new ObjectMapper();
			weatherDto = mapper.readValue(content.toString(), WeatherDto.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
		
			
			
			
		
		
		return weatherDto;
	}
	
	/**
	 * Generate an URL with HTTP params
	 * @param basePath
	 * @param params
	 * @return URL
	 * @throws MalformedURLException
	 */
	private URL generateUrl(String basePath, Map<String, String> params) throws MalformedURLException {
		String paramsFormatted = this.generateParams(params);
		String pathFormatted = paramsFormatted.length() > 0 ? 
				new StringBuilder(basePath).append("?").append(paramsFormatted).toString() : basePath;
				
		return new URL(pathFormatted);
	}
	
	/**
	 * generate params for HTTP request
	 * format : "key=value&key2=value2"
	 * @param params
	 * @return params formatted
	 */
	private String generateParams(Map<String, String> params) {
		StringBuilder paramsBuilder = new StringBuilder();

		params.forEach((key, value)-> {
			paramsBuilder.append(key).append("=").append(value).append("&");
		});
		String paramsFormatted = paramsBuilder.toString();
		
		return paramsFormatted.length() > 0 ? 
				paramsFormatted.substring(0, paramsFormatted.length() -1) : paramsFormatted;
	}

}
