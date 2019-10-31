package fr.nextoo.weatherforecast.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.nextoo.weatherforecast.dto.WeatherDto;
import fr.nextoo.weatherforecast.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Value("${weather.api.key}")
    private String key;

    private static final String URL = "http://api.openweathermap.org/data/2.5/forecast?q={city}&APPID={key}&units=metric";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<WeatherDto> getWeatherByCity(String ville) {
        return parseJSONtoWeatherDto(restTemplate.getForObject(URL, String.class, ville, key));
    }

    private List<WeatherDto> parseJSONtoWeatherDto(String response) {
        List<WeatherDto> responseApi = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> map = objectMapper.readValue(response, new TypeReference<Map<String, Object>>() {
            });
            for (Map<String, Object> forecast : (ArrayList<Map>) map.get("list")) {
                JSONObject json = new JSONObject(forecast);
                JSONObject jsonMain = (JSONObject) json.get("main");
                JSONObject jsonWeather = (JSONObject) ((JSONArray) json.get("weather")).get(0);
                responseApi.add(new WeatherDto(
                        convertToDate(json.getString("dt_txt")).toString(),
                        jsonMain.getDouble("temp_max"),
                        jsonMain.getDouble("temp_min"),
                        jsonMain.getDouble("humidity"),
                        jsonWeather.getString("description").contains("rain")
                ));
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return responseApi;
    }

    private LocalDate convertToDate(String param) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDate localDate = LocalDate.parse(param, formatter);
        return localDate;
    }
}
