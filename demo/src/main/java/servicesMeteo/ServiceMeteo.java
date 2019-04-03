package servicesMeteo;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.projet.dto.FcstDayDto;
import com.projet.dto.HotestDay;
import com.projet.dto.HourlyDataDto;
import com.projet.dto.InfoHumidity;
import com.projet.dto.MeteoCityDto;



public class ServiceMeteo {

	private final static String URL = "http://www.prevision-meteo.ch/services/json/";
	private RestTemplate restTemplate;
	private ResponseEntity<MeteoCityDto> response;

	public ServiceMeteo() {
		this.restTemplate = new RestTemplate();	
	}


	/*
	 * Obtenir les infos du jour et de la semaine via une ville donnée
	 * @param une ville donnée
	 */
	public MeteoCityDto getMeteoCity(String city) throws IOException  {

		response = restTemplate.getForEntity((URL+city), MeteoCityDto.class);	
		return response.getBody();
	}


	/*
	 * Obtenir le jour le plus chaud de la semaine via une ville donnée
	 * @param une ville donnée
	 */
	public HotestDay getHotestDayOfWeek(String city) {

		response = restTemplate.getForEntity((URL+city), MeteoCityDto.class);

		//liste contenant les cinq jours de la semaine
		List<FcstDayDto> list = Arrays.asList(
				response.getBody().getFcstDay0(),
				response.getBody().getFcstDay1(), 
				response.getBody().getFcstDay2(),
				response.getBody().getFcstDay3(),
				response.getBody().getFcstDay4()
				);

		//critére de comparaison pour un jour donné
		Comparator<FcstDayDto> comparator = Comparator.comparing(FcstDayDto::getTempMax);

		//récupération du jour le plus chaud de la semaine avec pour critére de comparaison "comparator"
		FcstDayDto day = list.stream().max(comparator).get();
		return new HotestDay(day.getDate(),day.getNameOfDay(),day.getCondition(),day.getTempMax());

	}

	/*
	 * Obtenir les jour pluvieux de la semaine via une ville donnée
	 * @param une ville donnée
	 */
	public List<FcstDayDto> getDaysOfRain(String city) {
		response = restTemplate.getForEntity((URL+city), MeteoCityDto.class);

		//liste contenant les cinq jours de la semaine
		List<FcstDayDto> list = Arrays.asList(
				response.getBody().getFcstDay0(),
				response.getBody().getFcstDay1(), 
				response.getBody().getFcstDay2(),
				response.getBody().getFcstDay3(),
				response.getBody().getFcstDay4()
				);

		Stream<FcstDayDto> sp = list.stream();

		//list contenant les jours de la semaine où le mot "pluie" figure
		list = sp.filter(x -> x.getCondition().toLowerCase().contains("pluie"))
				.map(x -> x)
				.collect(Collectors.toList());

		return list;
	}


	public InfoHumidity getHumidityOfDayAndWeek(String city) {
		response = restTemplate.getForEntity((URL+city), MeteoCityDto.class);


		List<FcstDayDto> list = Arrays.asList(
				response.getBody().getFcstDay0(),
				response.getBody().getFcstDay1(), 
				response.getBody().getFcstDay2(),
				response.getBody().getFcstDay3(),
				response.getBody().getFcstDay4()
				);

		
		Double moyenne = 0.0;

		//boucle sur chaque jour de la semaine contenu dans liste
		for(FcstDayDto fcstDayDto: list){

			//on additionne la moyenne de chaque jour de la semaine
			moyenne += fcstDayDto.getHourlyData().entrySet().stream()
                    .mapToDouble(x -> x.getValue().getHumidity())
                    .average()
                    .getAsDouble();
		}		
		
		//on divise le resultat par le nombre de jour dans la liste
		moyenne /= list.size();
		//on arrondi au centième
		moyenne = (double)Math.round(moyenne * 100) / 100;
		
		return new InfoHumidity(response.getBody().getCurrentCondition().getHumidity(), moyenne);
	}
}
