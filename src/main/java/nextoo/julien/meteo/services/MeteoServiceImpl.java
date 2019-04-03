package nextoo.julien.meteo.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nextoo.julien.meteo.services.api.MeteoApiService;
import nextoo.julien.meteo.services.api.dto.HumiditeReponseDto;
import nextoo.julien.meteo.services.api.dto.JourReponseDto;
import nextoo.julien.meteo.services.api.dto.MeteoResponseDto;
import nextoo.julien.meteo.services.api.dto.PrevisionDto;
import nextoo.julien.meteo.services.api.dto.PrevisionHeureDto;

@Service
public class MeteoServiceImpl implements MeteoService {

	@Autowired
	private MeteoApiService meteoApiService;

	@Override
	public MeteoResponseDto getMeteo(String ville) throws IOException {
		return meteoApiService.getMeteo(ville);
	}

	@Override
	public JourReponseDto getJourLePlusChaud(String ville) throws IOException {

		MeteoResponseDto meteo = meteoApiService.getMeteo(ville);

		Collection<PrevisionDto> prev = meteo.getPrevisionsList();

		final Comparator<PrevisionDto> comp = (p1, p2) -> Double.compare(p1.getTmpMax(), p2.getTmpMax());

		PrevisionDto previsionJourChaud = 
				prev.stream()
					.max(comp)
//					.map(jourChaud -> new JourReponseDto(jourChaud.get, date, tmpMin, tmpMax, condition)))
					.get();
		
		JourReponseDto jourPlusChaud = new JourReponseDto();
		jourPlusChaud.setJour(previsionJourChaud.getJour());
		jourPlusChaud.setDate(previsionJourChaud.getDate());
		jourPlusChaud.setCondition(previsionJourChaud.getCondition());
		jourPlusChaud.setTmpMax(previsionJourChaud.getTmpMax());
		jourPlusChaud.setTmpMin(previsionJourChaud.getTmpMin());
		
		return jourPlusChaud;
	}

	@Override
	public Collection<JourReponseDto> getJourPluie(String ville) throws IOException {

		Collection<JourReponseDto> listeJourPluie = new ArrayList<JourReponseDto>();
		
		MeteoResponseDto meteo = meteoApiService.getMeteo(ville);

		Collection<PrevisionDto> previsions = meteo.getPrevisionsList();

		Collection<PrevisionDto> res = previsions.stream().filter(p -> p.getCondition().toLowerCase().contains("pluie"))
				.collect(Collectors.toList());
		
//		res.forEach(prevision -> {
//			JourReponseDto tmpJour = new JourReponseDto();
//			tmpJour.
//		});

		return listeJourPluie;
	}

	@Override
	public HumiditeReponseDto getHumidite(String ville) throws IOException {
		MeteoResponseDto meteo = meteoApiService.getMeteo(ville);
		
		HumiditeReponseDto humiditeReponse = new HumiditeReponseDto();
		
		humiditeReponse.setHumiditeCourante(meteo.getConditionCourante().getHumidity());

		Collection<PrevisionHeureDto> previsionsJ0 = meteo.getPrevision_j0().getPrevisionsParHeure()
				.previsionsHeureToListe();

		double moyenneJ0 = previsionsJ0.stream().mapToDouble(p -> p.getHumidite()).average().getAsDouble();

		Collection<PrevisionHeureDto> previsionsJ1 = meteo.getPrevision_j0().getPrevisionsParHeure()
				.previsionsHeureToListe();

		double moyenneJ1 = previsionsJ1.stream().mapToDouble(p -> p.getHumidite()).average().getAsDouble();

		Collection<PrevisionHeureDto> previsionsJ2 = meteo.getPrevision_j0().getPrevisionsParHeure()
				.previsionsHeureToListe();

		double moyenneJ2 = previsionsJ2.stream().mapToDouble(p -> p.getHumidite()).average().getAsDouble();

		Collection<PrevisionHeureDto> previsionsJ3 = meteo.getPrevision_j0().getPrevisionsParHeure()
				.previsionsHeureToListe();

		double moyenneJ3 = previsionsJ3.stream().mapToDouble(p -> p.getHumidite()).average().getAsDouble();

		Collection<PrevisionHeureDto> previsionsJ4 = meteo.getPrevision_j0().getPrevisionsParHeure()
				.previsionsHeureToListe();

		double moyenneJ4 = previsionsJ4.stream().mapToDouble(p -> p.getHumidite()).average().getAsDouble();
		
		humiditeReponse.setHumiditeMoyenneSemaine((moyenneJ0 + moyenneJ1 + moyenneJ2 + moyenneJ3 + moyenneJ4) /5);
		
		humiditeReponse.setIndicateurHumidite();

		return humiditeReponse;
	}

}
