package nextoo.julien.meteo.services.api;

import java.io.IOException;

import nextoo.julien.meteo.services.api.dto.MeteoResponseDto;

public interface MeteoApiService {
	public MeteoResponseDto getMeteo(String ville) throws IOException;
}
