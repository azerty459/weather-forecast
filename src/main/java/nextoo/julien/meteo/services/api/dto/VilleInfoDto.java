package nextoo.julien.meteo.services.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import nextoo.julien.meteo.controller.dto.VilleInfoReponseDto;

public class VilleInfoDto {

	@JsonProperty("name")
	private String nom;

	@JsonProperty("country")
	private String pays;

	@JsonProperty("latitude")
	private double latitude;

	@JsonProperty("longitude")
	private double longitude;

	@JsonProperty("elevation")
	private double altitude;

	public VilleInfoDto() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

	public VilleInfoReponseDto convertToVilleInfoReponseDto() {
		VilleInfoReponseDto villeReponse = new VilleInfoReponseDto();

		villeReponse.setNom(this.nom);
		villeReponse.setPays(this.pays);
		villeReponse.setAltitude(this.altitude);
		villeReponse.setLatitude(this.latitude);
		villeReponse.setLongitude(this.longitude);

		return villeReponse;
	}

}
