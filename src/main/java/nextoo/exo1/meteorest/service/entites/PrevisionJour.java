package nextoo.exo1.meteorest.service.entites;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liam
 */
public class PrevisionJour {
	
	/**
	 * Represente l'evolution de l'humidite par heure
	 */
	Map<String, PrevisionHeure> parHeure = new HashMap<String, PrevisionHeure>();
	
	/**
	 * Represente la date du bulletin meteo.
	 */
	private String dateDuBulletin;
	
	/**
	 * Exprime les conditions, si il pleut, si il y a du soleil...
	 */
	private String condition;
	
	/**
	 * Represente soit la temperature actuelle pour la meteo du jour, soit la meteo prevue pour une prevision.
	 */
	private double temperature;
	
	/**
	 * Represente le niveau d'humidite
	 */
	private int humidite;
	
	/**
	 * Represente la temperature minimale pour la date renseignee.
	 */
	private double temperatureMin;
	
	/**
	 * Represente la temperature maximale pour la date renseingnee.
	 */
	private double temperatureMax;

	private String icon;
	
	public PrevisionJour() {
		
	}

	/**
	 * @return the dateDuBulletin
	 */
	public String getDateDuBulletin() {
		return dateDuBulletin;
	}

	/**
	 * @param dateDuBulletin the dateDuBulletin to set
	 */
	public void setDateDuBulletin(String dateDuBulletin) {
		this.dateDuBulletin = dateDuBulletin;
	}

	/**
	 * @return the temperatureActuelle
	 */
	public double getTemperature() {
		if(this.temperature == 0)
			this.temperature = (this.temperatureMin+this.temperatureMax)/2;
		return temperature;
	}

	/**
	 * @param temperature the temperature Actuelle to set
	 */
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	/**
	 * @return the temperatureMin
	 */
	public double getTemperatureMin() {
		return temperatureMin;
	}

	/**
	 * @param temperatureMin the temperatureMin to set
	 */
	public void setTemperatureMin(double temperatureMin) {
		this.temperatureMin = temperatureMin;
	}

	/**
	 * @return the temperatureMax
	 */
	public double getTemperatureMax() {
		return temperatureMax;
	}

	/**
	 * @param temperatureMax the temperatureMax to set
	 */
	public void setTemperatureMax(double temperatureMax) {
		this.temperatureMax = temperatureMax;
	}

	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * @param condition the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	/**
	 * @return the humidite
	 */
	public int getHumidite() {
		return humidite;
	}

	/**
	 * @param humidite the humidite to set
	 */
	public void setHumidite(int humidite) {
		this.humidite = humidite;
	}

	/**
	 * @return the parHeure
	 */
	public Map<String, PrevisionHeure> getParHeure() {
		return parHeure;
	}

	/**
	 * @param parHeure the parHeure to set
	 */
	public void setParHeure(Map<String, PrevisionHeure> parHeure) {
		this.parHeure = parHeure;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
}
