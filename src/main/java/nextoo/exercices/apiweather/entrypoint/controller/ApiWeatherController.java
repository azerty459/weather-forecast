package nextoo.exercices.apiweather.entrypoint.controller;

import nextoo.exercices.apiweather.business.MainBusiness;
import nextoo.exercices.apiweather.entrypoint.dto.ForecastDTO;
import nextoo.exercices.apiweather.entrypoint.dto.HottestDayDTO;
import nextoo.exercices.apiweather.entrypoint.dto.RainyDaysDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ApiWeatherController {

	@Autowired
	private MainBusiness mainBusiness;

	@RequestMapping(value = "/forecast", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ForecastDTO forecast(@RequestParam(value="city", defaultValue="lille") String cityName) {
		return mainBusiness.getForecast(cityName);
	}

	@RequestMapping(value = "/hottestDay", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public HottestDayDTO hottestDay(@RequestParam(value="city", defaultValue="lille") String cityName) {
		return mainBusiness.getHottestDay(cityName);
	}

	@RequestMapping(value = "/rainyDays", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public RainyDaysDTO rainyDays(@RequestParam(value="city", defaultValue="lille") String cityName) {
		return mainBusiness.getRainyDays(cityName);
	}
	
}
