package nextoo.exo1.meteorest.controller;

import java.util.Map;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import nextoo.exo1.meteorest.objects.Meteo;
import nextoo.exo1.meteorest.objects.TraitementJson;
import nextoo.exo1.meteorest.service.PrevisionService;

/**
 * @author liam
 * @version java 1.8
 */
@RestController
@RequestMapping("/meteo/{ville}")
public class MeteoController {
	
	@Autowired
	PrevisionService ps;

	@RequestMapping("/")
	public TraitementJson meteoParVille(@PathVariable String ville) {
		TraitementJson previ = ps.recuperationJson(ville);
		return previ;
	}
	
	@RequestMapping("/hot")
	public Meteo jourChaud(@PathVariable String ville) {
		return ps.jourLePlusChaud(ville);
	}
	
	@RequestMapping("/pluie")
	public Stream<Meteo> joursDePluie(@PathVariable String ville) {
		return ps.jourDePluie(ville);
	}
	
	@RequestMapping("/humidite")
	public Map<String, String> semaineHumiditeMoyenne(@PathVariable String ville) {
		return ps.humiditeSemaine(ville);
	}
}
