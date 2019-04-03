package nextoo.exo1.meteorest.service;

import java.util.Map;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;
import nextoo.exo1.meteorest.objects.Meteo;
import nextoo.exo1.meteorest.objects.TraitementJson;

/**
 * @author liam
 */
@Service
public interface PrevisionService {
	/**
	 * Va recuperer la meteo pour la ville passee en parametre
	 * @param ville type String, represente le nom de la ville
	 * @return un objet TraitementJson qui contient la meteo
	 */
	public TraitementJson recuperationJson(String ville);
	
	/**
	 * Va donner le jour le plus chaud de la semaine
	 * @param ville type String, represente le nom de la ville
	 * @return un objet meteo qui contient le jour le plus chaud
	 */
	public Meteo jourLePlusChaud(String ville);
	
	/**
	 * Va donner les jours de pluie pour une ville donnee
	 * @param ville type String, represente le nom de la ville
	 * @return La liste des jours de pluie
	 */
	public Stream<Meteo> jourDePluie(String ville);
	
	/**
	 * Donne l'humidite moyenne de la semaine pour une ville donnee
	 * @param ville type String, represente le nom de la ville
	 * @return une HashMap qui contient comme cle l'element renvoye et comme valeur l'element specifie dans la cle
	 */
	public Map<String, String> humiditeSemaine(String ville);
}
