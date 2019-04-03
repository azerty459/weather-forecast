package nextoo.julien.meteo.controller;

import java.io.IOException;
import java.util.Collection;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nextoo.julien.meteo.controller.dto.HumiditeReponseDto;
import nextoo.julien.meteo.controller.dto.JourReponseDto;
import nextoo.julien.meteo.controller.dto.MeteoReponseDto;
import nextoo.julien.meteo.services.MeteoServiceImpl;

@RestController
@RequestMapping("/meteo")
public class MeteoController {
	
	@Autowired
	MeteoServiceImpl meteoService;
	
	@GetMapping("/ville/{ville}")
	public MeteoReponseDto getVilleMeteo(@PathVariable("ville") @NotNull String ville) throws IOException{
		
		return meteoService.getMeteo(ville);
	}
	
	@GetMapping("/ville/{ville}/jour-plus-chaud")
	public JourReponseDto getJourLePlusChaud(@PathVariable("ville") @NotNull String ville) throws IOException{
		
		return meteoService.getJourLePlusChaud(ville);
	}
	
	@GetMapping("/ville/{ville}/jour-pluie")
	public Collection<JourReponseDto> getJourPluie(@PathVariable("ville") @NotNull String ville) throws IOException{
		
		return meteoService.getJourPluie(ville);
	}
	
	@GetMapping("/ville/{ville}/humidite")
	public HumiditeReponseDto getHumidite(@PathVariable("ville") @NotNull String ville) throws IOException{
		
		return meteoService.getHumidite(ville);
	}
}
