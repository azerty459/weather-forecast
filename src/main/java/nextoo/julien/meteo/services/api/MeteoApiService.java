package nextoo.julien.meteo.services.api;

import java.io.IOException;

import nextoo.julien.meteo.services.api.dto.MeteoDto;

public interface MeteoApiService {
	public MeteoDto getMeteo(String ville) throws IOException;
}
