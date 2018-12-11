package com.nextoo.exercices.weatherforecast;


import com.nextoo.exercices.weatherforecast.services.TownWeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author nextoo
 */
@SpringBootApplication
public class WeatherForecastApplication {

    private static final Logger logger = LoggerFactory.getLogger(WeatherForecastApplication.class);

	public WeatherForecastApplication() {
		logger.info("demarrage de l'application WeatherForecastApplication");
	}


	public static void main(String[] args) {
		SpringApplication.run(WeatherForecastApplication.class, args);
        logger.info("deploye ...");
	}
}
