package nextoo.julien.meteo.services;

import java.io.IOException;
import java.util.Collection;

import nextoo.julien.meteo.controller.dto.HumiditeReponseDto;
import nextoo.julien.meteo.controller.dto.JourReponseDto;
import nextoo.julien.meteo.controller.dto.MeteoReponseDto;
import nextoo.julien.meteo.services.api.dto.MeteoDto;
import nextoo.julien.meteo.services.api.exception.HumiditeNonTrouveApiException;

public interface MeteoService {
	
	public MeteoReponseDto getMeteo(String ville) throws IOException;
		
	public JourReponseDto getJourLePlusChaud(String ville) throws IOException, Exception;
	
	public Collection<JourReponseDto> getJourPluie(String ville) throws IOException;
	
	public HumiditeReponseDto getHumidite(String ville) throws IOException, HumiditeNonTrouveApiException;

}
