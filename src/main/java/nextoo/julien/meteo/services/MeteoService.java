package nextoo.julien.meteo.services;

import java.io.IOException;
import java.util.Collection;

import nextoo.julien.meteo.services.api.dto.HumiditeReponseDto;
import nextoo.julien.meteo.services.api.dto.JourReponseDto;
import nextoo.julien.meteo.services.api.dto.MeteoResponseDto;

public interface MeteoService {
	
	public MeteoResponseDto getMeteo(String ville) throws IOException;
		
	public JourReponseDto getJourLePlusChaud(String ville) throws IOException;
	
	public Collection<JourReponseDto> getJourPluie(String ville) throws IOException;
	
	public HumiditeReponseDto getHumidite(String ville) throws IOException;

}
