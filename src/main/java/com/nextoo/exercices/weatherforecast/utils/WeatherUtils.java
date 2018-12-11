package com.nextoo.exercices.weatherforecast.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

/**
 * @author nextoo
 */
public class WeatherUtils {

    public static final String getDayFromDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
        LocalDate aujourdhui = LocalDate.now();
        if (aujourdhui.isEqual(LocalDate.parse(date.toString()))) {
            return "AUJOURD'HUI";
        }
        return simpleDateFormat.format(date).toUpperCase() ;
    }

    public static final String formatFullDate(LocalDate date) {
        if (LocalDate.now().isEqual(date)) {
            return "AUJOURD'HUI";
        }
        return DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(date);
    }
}
