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
@RequestMapping("/meteo")
public class MeteoController {
	
	@Autowired
	PrevisionService ps;

	@RequestMapping("/{city}")
	public TraitementJson findByCity(@PathVariable String city) {
		TraitementJson previ = ps.recuperationJson(city);
		return previ;
	}
	
	@RequestMapping("/{city}/hot")
	public Meteo jourChaud(@PathVariable String city) {
		return ps.jourLePlusChaud(city);
	}
	
	@RequestMapping("{city}/pluie")
	public Stream<Meteo> pluie(@PathVariable String city) {
		return ps.jourDePluie(city);
	}
	
	@RequestMapping("{city}/humidite")
	public Map<String, String> humidite(@PathVariable String city) {
		return ps.humiditeSemaine(city);
	}
}
