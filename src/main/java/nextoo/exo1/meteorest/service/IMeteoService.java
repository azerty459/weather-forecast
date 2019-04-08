package nextoo.exo1.meteorest.service;

import java.util.Map;
import java.util.stream.Stream;

import nextoo.exo1.meteorest.controller.dto.PrevisionJourDTO;
import nextoo.exo1.meteorest.controller.dto.PrevisionSemaineDTO;

/**
 * @author liam
 */
public interface IMeteoService {
	/**
	 * Va recuperer la meteo pour la ville passee en parametre
	 * @param ville type String, represente le nom de la ville
	 * @return un objet PrevisionSemaine qui contient la meteo
	 */
	PrevisionSemaineDTO appelApiMeteo(String ville);
	
	/**
	 * Va donner le jour le plus chaud de la semaine
	 * @param ville type String, represente le nom de la ville
	 * @return un objet meteo qui contient le jour le plus chaud
	 */
	PrevisionJourDTO jourLePlusChaud(String ville);
	
	/**
	 * Va donner les jours de pluie pour une ville donnee
	 * @param ville type String, represente le nom de la ville
	 * @return La liste des jours de pluie
	 */
	Stream<PrevisionJourDTO> jourDePluie(String ville);
	
	/**
	 * Donne l'humidite moyenne de la semaine pour une ville donnee
	 * @param ville type String, represente le nom de la ville
	 * @return une HashMap qui contient comme cle l'element renvoye et comme valeur l'element specifie dans la cle
	 */
	Map<String, String> humiditeSemaine(String ville);
}
