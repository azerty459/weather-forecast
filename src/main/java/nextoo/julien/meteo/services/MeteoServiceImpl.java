package nextoo.julien.meteo.services;

import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nextoo.julien.meteo.controller.dto.HumiditeReponseDto;
import nextoo.julien.meteo.controller.dto.JourReponseDto;
import nextoo.julien.meteo.controller.dto.MeteoReponseDto;
import nextoo.julien.meteo.services.api.MeteoApiService;
import nextoo.julien.meteo.services.api.dto.MeteoDto;

@Service
public class MeteoServiceImpl implements MeteoService {

	@Autowired
	private MeteoApiService meteoApiService;

	@Override
	public MeteoReponseDto getMeteo(String ville) throws IOException {
		return meteoApiService.getMeteo(ville).convertToMeteoReponseDto();
	}

	@Override
	public JourReponseDto getJourLePlusChaud(String ville) throws IOException {

		MeteoDto meteo = meteoApiService.getMeteo(ville);

		final Comparator<JourReponseDto> comp = (p1, p2) -> Double.compare(p1.getTmpMax(), p2.getTmpMax());
 
		return meteo.getPrevisionsList().stream()
					.map(jourChaud -> jourChaud.convertToJourReponseDto())
					.max(comp)	
					.get();
	}

	@Override
	public Collection<JourReponseDto> getJourPluie(String ville) throws IOException {
		
		MeteoDto meteo = meteoApiService.getMeteo(ville);

		return meteo.getPrevisionsList().stream()
					.filter(p -> p.getCondition().toLowerCase().contains("pluie"))
					.map(jourPluie -> jourPluie.convertToJourReponseDto())
					.collect(Collectors.toList());
		
	}

	@Override
	public HumiditeReponseDto getHumidite(String ville) throws IOException {
		MeteoDto meteo = meteoApiService.getMeteo(ville);
		
		HumiditeReponseDto humiditeReponse = new HumiditeReponseDto();
		
		humiditeReponse.setHumiditeCourante(meteo.getConditionCourante().getHumidity());
		
		
		double humiditeMoyenne = meteo.getPrevisionsList()
				.stream()
				.mapToDouble(p -> p.getPrevisionsParHeure().values()
						.stream()
						.mapToDouble(h -> h.getHumidite())
						.average()
						.getAsDouble())
				.average()
				.getAsDouble();
		
		humiditeReponse.setHumiditeMoyenneSemaine(humiditeMoyenne);
		humiditeReponse.setIndicateurHumidite();

		return humiditeReponse;
	}

}
