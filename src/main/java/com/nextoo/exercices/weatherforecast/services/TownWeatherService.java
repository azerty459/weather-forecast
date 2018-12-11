package com.nextoo.exercices.weatherforecast.services;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nextoo.exercices.weatherforecast.dtos.TownWeatherDayDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;


/**
 * @author nextoo
 */
@Service
public class TownWeatherService  {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${language.default}")
    private String langue;

    @Value("${nextoo.weather.api.id}")
    private String weatherApiId;

    @Value("${weather.endpoint}")
    private String endpointurl;

    @Value("${daily.forecast.value}")
    private String dailyForecastValue;

    private static final String WEATHER_URL = "https://#endpointurl/data/2.5/forecast?q=#ville&cnt=#cnt&lang=#langue&appid=#apiId&units=metric";
    private static final Logger logger = LoggerFactory.getLogger(TownWeatherService.class);

    /**
     * donne la météo pour les prochains jours pour une ville
     * @param ville
     * @return
     */
    public String getWeatherForTown(final String ville) {
       String result = callWeatherTownUri(ville).toString();
       logger.info("météo pour les prochains jours : \n" + result);
       return result;
    }

    /**
     * donne le jour le plus chaud de la semaine
     * @param ville
     * @return
     */
    public String getHottestDayInWeek(final String ville) {
        List<TownWeatherDayDto> donnees = callWeatherTownUri(ville);
        if (donnees != null && !donnees.isEmpty()) {
            return donnees.stream().sorted(Comparator.comparing(TownWeatherDayDto::getMaxTemp).reversed()).findFirst().get().getFormattedDate();
        }
        return null;
    }


    /**
     * donne les jours où il pleut
     * @param ville
     * @return
     */
    public String getRainyDays(final String ville) {
        List<TownWeatherDayDto> donnees = callWeatherTownUri(ville);
        if (donnees != null && !donnees.isEmpty()) {
            final List<TownWeatherDayDto> joursPluvieux = donnees.stream().filter(w -> w.isJourPluvieux()).collect(Collectors.toList());
            String result = "les jours pluvieux sont : ";
            result += joursPluvieux.stream().map(TownWeatherDayDto::getFormattedDate).collect(Collectors.toList()).toString();
            logger.info(result);
            return result;
        }
        return null;
    }


    /**
     * donne l'humidite de la journée
     * @param ville
     * @return
     */
    public Double getTodayHumidityValue(final String ville) {
        List<TownWeatherDayDto> donnees = callWeatherTownUriWithParameters(ville, "1");
        if (donnees != null && !donnees.isEmpty()) {
          return donnees.stream().findFirst().get().getHumidite();
        }
        return null;
    }

    /**
     * donne la moyenne de l'humidite
     * @param ville
     * @return
     */
    public OptionalDouble getWeekHumidityAverage(final String ville) {
        List<TownWeatherDayDto> donnees = callWeatherTownUri(ville);
        if (donnees != null && !donnees.isEmpty()) {
           return donnees.stream().mapToDouble(w -> w.getHumidite()).average();
        }
        return null;
    }

    /**
     * appel l'api avec la ville en parametre
     * @param ville
     * @return
     */
    private List<TownWeatherDayDto> callWeatherTownUri(final String ville) {
        if (!StringUtils.isEmpty(ville)) {
            final String weatherUrl = getWeatherUrl(ville);
            logger.info("appel de l'api avec les parametres : " + weatherUrl);
            return convertJsonToWeatherList(restTemplate.getForObject(weatherUrl, String.class), ville);
        }
        return null;
    }


    /**
     * appel l'api avec la ville pour aujourd'hui
     * @param ville
     * @param cnt
     * @return
     */
    private List<TownWeatherDayDto> callWeatherTownUriWithParameters(final String ville, final String cnt) {
        if (!StringUtils.isEmpty(ville)) {
            final String weatherUrl = getWeatherUrlByVilleAndCount(ville, cnt);
            logger.info("appel de l'api avec les parametres : " + weatherUrl);
            return convertJsonToWeatherList(restTemplate.getForObject(weatherUrl, String.class), ville);
        }
        return null;
    }


    private String getWeatherUrl(final String ville) {
       return WEATHER_URL.replace("#endpointurl", endpointurl)
               .replace("#ville", ville)
               .replace("#langue", langue)
               .replace("#apiId", weatherApiId)
               .replace("#cnt", dailyForecastValue);
    }

    private String getWeatherUrlByVilleAndCount(final String ville, final String cnt) {
        return WEATHER_URL.replace("#endpointurl", endpointurl)
                .replace("#ville", ville)
                .replace("#langue", langue)
                .replace("#apiId", weatherApiId)
                .replace("#cnt", cnt);
    }

    private List<TownWeatherDayDto> convertJsonToWeatherList(final String meteoParJour, final String ville) {
        List<TownWeatherDayDto> result = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> map = objectMapper.readValue(meteoParJour, new TypeReference<Map<String, Object>>() {
            });
            if (map.get("list") != null) {
                for (Map<String, Object> forecast : (ArrayList<Map>) map.get("list")) {
                    JSONObject json = new JSONObject(forecast);
                    JSONObject jsonWind = (JSONObject) json.get("wind");
                    JSONObject jsonMain = (JSONObject) json.get("main");
                    JSONObject jsonWeather = (JSONObject) ((JSONArray) json.get("weather")).get(0);
                    LocalDate dateMeteo = LocalDate.parse(json.getString("dt_txt"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    if (!result.stream().filter(w -> w.getJour().isEqual(dateMeteo)).findFirst().isPresent()) {
                        result.add(new TownWeatherDayDto(ville,
                                dateMeteo,
                                jsonMain.getDouble("temp_min"),
                                jsonMain.getDouble("temp_max"),
                                jsonWind.getDouble("speed"),
                                jsonMain.getDouble("humidity"),
                                jsonMain.getDouble("pressure"),
                                jsonWeather.getString("description"),
                                jsonWeather.getString("description").contains("pluie")
                        ));
                    } else {
                        TownWeatherDayDto w = result.stream().filter(e -> e.getJour().isEqual(dateMeteo)).findAny().get();
                        w.setMinTemp((w.getMinTemp() + jsonMain.getDouble("temp_min")) / 2);
                        w.setMaxTemp((w.getMaxTemp()) + jsonMain.getDouble("temp_max") / 2);
                        w.setVent((w.getVent() + jsonWind.getDouble("speed")) / 2);
                        w.setHumidite((w.getHumidite() + jsonMain.getDouble("humidity")) / 2);
                        w.setPression((w.getPression() + jsonMain.getDouble("pressure")) / 2);
                        w.setJourPluvieux(w.isJourPluvieux() || jsonWeather.getString("description").contains("pluie"));
                    }

                }
            }
        } catch (JsonGenerationException jgex) {
            logger.error("une erreur de conversion est survenue : " + jgex.getMessage());
        } catch (JsonMappingException jmex) {
            logger.error("une erreur de conversion est survenue : " + jmex.getMessage());
        } catch (Exception ex) {
            logger.error("une erreur est survenue lors de la conversion des données météo : " + ex.getMessage());
        } finally {
            return result;
        }
    }
}
