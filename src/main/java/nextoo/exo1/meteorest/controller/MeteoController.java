package nextoo.exo1.meteorest.controller;

import java.util.Map;
import java.util.stream.Stream;

import nextoo.exo1.meteorest.entites.PrevisionSemaine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import nextoo.exo1.meteorest.entites.PrevisionJour;
import nextoo.exo1.meteorest.service.IMeteoService;

/**
 * @author liam
 */
@RestController
@RequestMapping("/meteo/{ville}")
public class MeteoController {
	
	@Autowired
    IMeteoService ps;

	@RequestMapping("/")
	public PrevisionSemaine meteoParVille(@PathVariable String ville) {
		return ps.recuperationJson(ville);
	}
	
	@RequestMapping("/hot")
	public PrevisionJour jourChaud(@PathVariable String ville) {
		return ps.jourLePlusChaud(ville);
	}
	
	@RequestMapping("/pluie")
	public Stream<PrevisionJour> joursDePluie(@PathVariable String ville) {
		return ps.jourDePluie(ville);
	}
	
	@RequestMapping("/humidite")
	public Map<String, String> semaineHumiditeMoyenne(@PathVariable String ville) {
		return ps.humiditeSemaine(ville);
	}
}
