package com.nextoo.weather.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VilleInfos {
	@JsonProperty("name")
	String nomVille;
	@JsonProperty("country")
	String pays;
	@JsonProperty("latitude")
	double latitude;
	@JsonProperty("longitude")
	double longitude;
	
	
	public VilleInfos() {
		
	}


	public String getNomVille() {
		return nomVille;
	}


	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}


	public String getPays() {
		return pays;
	}


	public void setPays(String pays) {
		this.pays = pays;
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

	
}
