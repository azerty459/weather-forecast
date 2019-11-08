package fr.nextoo.weatherforecast.service.util;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class Utility {

    public String formatter(Instant dateTime) {
        DateTimeFormatter formatter =
                DateTimeFormatter
                        .ofPattern("yyyy-MM-dd HH:mm")
                        .withLocale( Locale.FRANCE )
                        .withZone( ZoneId.systemDefault() );
        return formatter.format(dateTime);
    }
}