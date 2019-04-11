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
import nextoo.julien.meteo.services.api.dto.PrevisionHeureDto;
import nextoo.julien.meteo.services.api.exception.HumiditeNonTrouveApiException;
import nextoo.julien.meteo.services.api.exception.JourNonTrouveApiException;

@Service
public class MeteoServiceImpl implements MeteoService {

	@Autowired
	private MeteoApiService meteoApiService;

	@Override
	public MeteoReponseDto getMeteo(String ville) throws IOException {
		return meteoApiService.getMeteo(ville).convertToMeteoReponseDto();
//		return meteoApiService.getMeteo(ville);
	}

	@Override
	public JourReponseDto getJourLePlusChaud(String ville) throws JourNonTrouveApiException, IOException{

		MeteoDto meteo = meteoApiService.getMeteo(ville);
 
		return meteo.getPrevisionsList().stream()
					.map(jourChaud -> jourChaud.convertToJourReponseDto())
					.max(Comparator.comparing(JourReponseDto::getTmpMax))
					.orElseThrow(() -> new JourNonTrouveApiException());
	}

	@Override
	public Collection<JourReponseDto> getJourPluie(String ville) throws IOException {
		
		MeteoDto meteo = meteoApiService.getMeteo(ville);
		
			return meteo.getPrevisionsList()
					.stream().filter(p -> p.getPrevisionsParHeure().values()
							.stream()
							.mapToDouble(PrevisionHeureDto::getPrecipitation)
							.sum() > 0.1
							).map(jourPluie -> jourPluie.convertToJourReponseDto())
					.collect(Collectors.toList());
		
		//GET PAR INTITULE DE LA CONDITION
//		return meteo.getPrevisionsList().stream()
//					.filter(p -> p.getCondition().toLowerCase().contains("pluie")) //niveau de precipitation
//					.map(jourPluie -> jourPluie.convertToJourReponseDto())
//					.collect(Collectors.toList());
		
	}

	@Override
	public HumiditeReponseDto getHumidite(String ville) throws IOException, HumiditeNonTrouveApiException {
		MeteoDto meteo = meteoApiService.getMeteo(ville);
		
		HumiditeReponseDto humiditeReponse = new HumiditeReponseDto();
		
		humiditeReponse.setHumiditeCourante(meteo.getConditionCourante().getHumidity());
		
		
		double humiditeMoyenne = meteo.getPrevisionsList()
				.stream()
				.mapToDouble(p -> p.getPrevisionsParHeure().values()
						.stream()
						.mapToDouble(PrevisionHeureDto::getHumidite)
						.average()
						.getAsDouble())
				.average()
				.orElseThrow(() -> new HumiditeNonTrouveApiException("Humidité moyenne de la semaine non trouvée dans l'API"));
		
		humiditeReponse.setHumiditeMoyenneSemaine(humiditeMoyenne);
		humiditeReponse.setIndicateurHumidite();

		return humiditeReponse;
	}

}
