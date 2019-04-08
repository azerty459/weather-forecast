package nextoo.exo1.meteorest.controller;

import java.util.Map;
import java.util.stream.Stream;
import nextoo.exo1.meteorest.controller.dto.PrevisionJourDTO;
import nextoo.exo1.meteorest.controller.dto.PrevisionSemaineDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import nextoo.exo1.meteorest.service.IMeteoService;

/**
 * @author liam
 */
@RestController
@RequestMapping("/meteo/{ville}")
public class MeteoController {
	
	@Autowired
    IMeteoService ps;

	@RequestMapping("")
	public PrevisionSemaineDTO meteoParVille(@PathVariable String ville) {
		return ps.appelApiMeteo(ville);
	}
	
	@RequestMapping("/jourChaud")
	public PrevisionJourDTO jourChaud(@PathVariable String ville) {
		return ps.jourLePlusChaud(ville);
	}
	
	@RequestMapping("/jourPluie")
	public Stream<PrevisionJourDTO> joursDePluie(@PathVariable String ville) {
		return ps.jourDePluie(ville);
	}
	
	@RequestMapping("/humiditeSemaine")
	public Map<String, String> humiditeSemaine(@PathVariable String ville) {
		return ps.humiditeSemaine(ville);
	}
}
