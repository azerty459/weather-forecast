package nextoo.julien.meteo.services;

import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nextoo.julien.meteo.controller.dto.HumiditeReponseDto;
import nextoo.julien.meteo.controller.dto.JourReponseDto;
import nextoo.julien.meteo.services.api.MeteoApiService;
import nextoo.julien.meteo.services.api.dto.MeteoDto;
import nextoo.julien.meteo.services.api.dto.PrevisionHeureDto;

@Service
public class MeteoServiceImpl implements MeteoService {

	@Autowired
	private MeteoApiService meteoApiService;

	@Override
	public MeteoDto getMeteo(String ville) throws IOException {
		return meteoApiService.getMeteo(ville);
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

		Collection<PrevisionHeureDto> previsionsJ0 = meteo.getPrevision_j0().getPrevisionsParHeure()
				.previsionsHeureToListe();

		double moyenneJ0 = previsionsJ0.stream().mapToDouble(p -> p.getHumidite()).average().getAsDouble();
		
//		double moyenneJ = previsionsJ0.stream()
//				.mapToDouble(p -> p.getHumidite())
//				.average()
//				.map(h -> h.)
//				.average()
//				.getAsDouble();

		Collection<PrevisionHeureDto> previsionsJ1 = meteo.getPrevision_j1().getPrevisionsParHeure()
				.previsionsHeureToListe();

		double moyenneJ1 = previsionsJ1.stream().mapToDouble(p -> p.getHumidite()).average().getAsDouble();

		Collection<PrevisionHeureDto> previsionsJ2 = meteo.getPrevision_j2().getPrevisionsParHeure()
				.previsionsHeureToListe();

		double moyenneJ2 = previsionsJ2.stream().mapToDouble(p -> p.getHumidite()).average().getAsDouble();

		Collection<PrevisionHeureDto> previsionsJ3 = meteo.getPrevision_j3().getPrevisionsParHeure()
				.previsionsHeureToListe();

		double moyenneJ3 = previsionsJ3.stream().mapToDouble(p -> p.getHumidite()).average().getAsDouble();

		Collection<PrevisionHeureDto> previsionsJ4 = meteo.getPrevision_j4().getPrevisionsParHeure()
				.previsionsHeureToListe();

		double moyenneJ4 = previsionsJ4.stream().mapToDouble(p -> p.getHumidite()).average().getAsDouble();
		
		humiditeReponse.setHumiditeMoyenneSemaine((moyenneJ0 + moyenneJ1 + moyenneJ2 + moyenneJ3 + moyenneJ4) /5);
		
		humiditeReponse.setIndicateurHumidite();

		return humiditeReponse;
	}

}
