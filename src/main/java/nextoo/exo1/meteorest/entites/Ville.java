package nextoo.exo1.meteorest.entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author liam
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ville {
	
	/**
	 * Represente le nom de la ville (ici on estime que le nom de la ville est son id unique bien que ce ne soit pas bien de faire comme ça).
	 */
	@JsonProperty("name")
	private String nom;
	
	/**
	 * Represente la latitude de la ville.
	 */
	@JsonProperty("latitude")
	private double lat;
	
	/**
	 * Represente la longitude de la ville.
	 */
	@JsonProperty("longitude")
	private double lon;
	
	/**
	 * Represente l'altitude de la ville.
	 */
	@JsonProperty("elevation")
	private double alt;
	
	public Ville() {
		
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the lat
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * @param lat the lat to set
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}

	/**
	 * @return the lon
	 */
	public double getLon() {
		return lon;
	}

	/**
	 * @param lon the lon to set
	 */
	public void setLon(double lon) {
		this.lon = lon;
	}

	/**
	 * @return the alt
	 */
	public double getAlt() {
		return alt;
	}

	/**
	 * @param alt the alt to set
	 */
	public void setAlt(double alt) {
		this.alt = alt;
	}
}
