package nxt.weather.exception;

public class WeatherCityNotFoundException extends WeatherException {

    public WeatherCityNotFoundException() {
    }

    public WeatherCityNotFoundException(String message) {
        super(message);
    }

    public WeatherCityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeatherCityNotFoundException(Throwable cause) {
        super(cause);
    }
    
}
