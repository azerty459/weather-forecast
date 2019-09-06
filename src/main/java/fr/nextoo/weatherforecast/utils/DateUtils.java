package fr.nextoo.weatherforecast.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class DateUtils {

	/**
	 * formatting Instant to LocalDate
	 * @param instant
	 * @return LocalDate
	 */
	public static LocalDate formattingInstantToLocalDate(Instant instant) {
		return LocalDate.ofInstant(instant, ZoneId.systemDefault());
	}
}
