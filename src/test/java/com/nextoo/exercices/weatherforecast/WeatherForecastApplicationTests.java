package com.nextoo.exercices.weatherforecast;

import com.nextoo.exercices.weatherforecast.services.TownWeatherService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;


/**
 * @author nextoo
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TownWeatherService.class, AppConfig.class}, loader = AnnotationConfigContextLoader.class)
@TestPropertySource("classpath:application.properties")
@SpringBootTest
public class WeatherForecastApplicationTests {

	@Autowired
	private TownWeatherService townWeatherService;


	@Test
	public void shouldGetForecastWeatherForTown() {
		Assertions.assertThat(townWeatherService.getWeatherForTown("lille")).isNotNull();
	}

	@Test
	public void shouldGetHottestDayInWeek() {
		Assertions.assertThat(townWeatherService.getHottestDayInWeek("lille")).isNotNull();
	}

	@Test
	public void shouldGetRainyDays() {
		Assertions.assertThat(townWeatherService.getRainyDays("lille")).isNotNull();
	}

	@Test
	public void shouldGetTodayHumidityValue() {
		Assertions.assertThat(townWeatherService.getTodayHumidityValue("lille")).isNotNull();
	}

	@Test
	public void shouldGetWeekHumidityAverage() {
		Assertions.assertThat(townWeatherService.getWeekHumidityAverage("lille")).isNotNull();
	}

}
